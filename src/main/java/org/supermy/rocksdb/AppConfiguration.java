package org.supermy.rocksdb;

import org.rocksdb.CompressionType;
import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

@SpringBootApplication
public class AppConfiguration {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(AppConfiguration.class);

	@Resource
	private Environment env;

	/**
	 *
	 * if (db != null) db.close();
	 options.dispose();

	 * @return
     */
	@Bean
	public RocksDB RocksDbConfig(){
		String filename = env.getRequiredProperty("db.file");

		log.debug("rocks db path:",filename);

		RocksDB.loadLibrary();
		// the Options class contains a set of configurable DB options
		// that determines the behavior of a database.
		Options options = new Options();
		options.setCompressionType(CompressionType.SNAPPY_COMPRESSION).setCreateIfMissing(true);

		RocksDB db = null;
		try {
			// a factory method that returns a RocksDB instance
			//String filename = "/Users/moyong/project/env-myopensource/1-spring/12-spring/rocksdb-service/src/main/resources/data";
			//db = factory.open(new File("example"), options);

			db = RocksDB.open(options, filename);
			// do something
		} catch (RocksDBException e) {
			e.printStackTrace();
		}
		return db;
	}



	public static void main(String[] args) {
		SpringApplication.run(AppConfiguration.class, args);
	}

}
