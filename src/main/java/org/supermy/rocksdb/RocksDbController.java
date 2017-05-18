package org.supermy.rocksdb;

import com.google.gson.Gson;
import org.rocksdb.Options;
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

import java.util.concurrent.atomic.AtomicLong;

/**
 * rocksdb 数据的文件存储
 */
//@RestController
@Controller
@RequestMapping("/rocksdb")
public class RocksDbController {
    //private static final org.slf4j.Logger log = LoggerFactory.getLogger(RocksDbController.class);
    private static final Logger log = LoggerFactory.getLogger(RocksDbController.class);

    @Autowired
    private RocksDB db;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    Greeting sayHello(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
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
    String set(@RequestParam(value = "key", required = false, defaultValue = "key1") String key, @RequestParam String value) {
        log.debug("set...{}  = ...{}", key, value);


//        byte[] key1;
//        byte[] key2;
// some initialization for key1 and key2
        try {
            //byte[] value = db.get(key1);
            Gson gson = new Gson();
            String json = gson.toJson(value);
            if (value != null) {  // value == null if key1 does not exist in db.
                db.put(key.getBytes(), json.getBytes());
                db.
            }
            // --db.remove(key1);
        } catch (RocksDBException e) {
            // error handling
            e.printStackTrace();
        }
        return "ok";
        //return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    /**
     * 获取json 数据
     *
     * @param value
     * @RequestBody
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public
    @ResponseBody
    String get(@RequestParam(value = "key", required = false, defaultValue = "key1") String key) {
        log.debug("set......{}", key);


        byte[] value = null;
//        byte[] key1;
//        byte[] key2;
// some initialization for key1 and key2
        try {
            value = db.get(key.getBytes());
//            if (value != null) {  // value == null if key1 does not exist in db.
//                db.put(key.getBytes(), value);
//            }
            // --db.remove(key1);
            return new String(value);
        } catch (RocksDBException e) {
            // error handling
            e.printStackTrace();
        }
        db.close();
//
//        //return new Greeting(counter.incrementAndGet(), String.format(template, name));

        return value.toString();

    }

    @RequestMapping(value = "/gt", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }


    /**
     * 服务器状态
     * @return
     */
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public @ResponseBody String status() throws RocksDBException {
        log.debug("status......{}");
        String stats = db.getProperty("rocksdb.stats");
        System.out.println(stats);
        return stats;
    }
//
//    /**
//     * 销毁数据库
//     * @return
//     */
//    @RequestMapping(value = "/destroy", method = RequestMethod.GET)
//    public @ResponseBody String destroy() throws RocksDBException {
//        log.debug("destroy......{}");
//        Options options = new Options();
//        factory.destroy(new File("example"), options);
//        return stats;
//    }

}


