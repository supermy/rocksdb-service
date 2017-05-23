package org.supermy.rocksdb;

import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * rocksdb 数据的文件存储
 */
//@RestController
@Controller
@RequestMapping("/rocksdb")
public class RocksDbController {
    private static final Logger log = LoggerFactory.getLogger(RocksDbController.class);

    @Autowired
    private RocksDB db;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Greeting sayHello(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    /**
     * 设定json 数据
     *
     * @param value
     * @RequestBody
     */
    @RequestMapping(value = "/set", method = RequestMethod.GET)
    public
    @ResponseBody
    CommonJson<HashMap> set(@RequestParam(value = "key", required = false, defaultValue = "key1") String key, @RequestParam String value) {
        log.debug("set...{}  = ...{}", key, value);
        HashMap<String,String> obj = new HashMap<String, String>();

        try {
            if (value != null) {  // value == null if key1 does not exist in db.
                db.put(key.getBytes(), value.getBytes());
            }
        } catch (RocksDBException e) {
            e.printStackTrace();

            obj.put("cause", e.getLocalizedMessage());
            return new CommonJson<HashMap>( false, "设置数据失败!", obj);

        }
        obj.put(key, value);

        return new CommonJson<HashMap>(true, "设置数据成功!", obj);
    }


    /**
     * 获取json 数据
     *
     * @param value
     * @RequestBody
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody
    CommonJson<HashMap> get(@RequestParam(value = "key", required = false, defaultValue = "key1") String key) {
        log.debug("set......{}", key);
        HashMap<String,String> obj = new HashMap<String, String>();

        String value = "数据不存在";
        try {
            byte[] value1 = db.get(key.getBytes());
            //db.put();
            if (value1 != null){
                value = new String(value1);
            }
//            if (value != null) {  // value == null if key1 does not exist in db.
//                db.put(key.getBytes(), value);
//            }
            // --db.remove(key1);
        } catch (RocksDBException e) {
            e.printStackTrace();

            obj.put("cause", e.getLocalizedMessage());
            return new CommonJson<HashMap>( false, "获取数据失败!", obj);

        }
        obj.put(key, value);

        return new CommonJson<HashMap>(true, "获取数据成功!", obj);

    }

    /**
     * 删除数据
     *
     * @param value
     * @RequestBody
     */
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public @ResponseBody
    CommonJson<HashMap> del(@RequestParam(value = "key", required = false, defaultValue = "key1") String key) {
        HashMap<String,String> obj = new HashMap<String, String>();

        log.debug("set......{}", key);
        try {
            db.singleDelete(key.getBytes());
        } catch (RocksDBException e) {
            e.printStackTrace();

            obj.put("cause", e.getLocalizedMessage());
            return new CommonJson<HashMap>( false, "删除数据失败!", obj);

        }
        obj.put(key, "");

        return new CommonJson<HashMap>(true, "删除数据成功!", obj);


    }


    /**
     * 服务器状态
     *
     * @return
     */
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public
    @ResponseBody
    String status() throws RocksDBException {
        log.debug("status......{}");
        String stats = db.getProperty("rocksdb.stats");
        System.out.println(stats);
        return stats;
    }


}


