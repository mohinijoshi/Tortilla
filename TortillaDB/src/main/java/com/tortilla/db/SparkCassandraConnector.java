package com.tortilla.db;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.cassandra.CassandraSQLContext;

/**
 * Created with IntelliJ IDEA.
 * User: uttam
 * Date: 8/31/15
 * Time: 11:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class SparkCassandraConnector {
    public static SparkConf conf;
    public static CassandraSQLContext sqlContext;

    public SparkCassandraConnector() {
        //following 2 lines connect to spark and cassandra from google cloud respectively.
        conf = new SparkConf().setAppName("spark count").setMaster("local[2]")  ;
        conf.set("spark.cassandra.connection.host", "146.148.48.21");
        conf.set("spark.driver.allowMultipleContexts", String.valueOf(true));
    }

    public SparkConf GetSparkConfig() {
        return conf;
    }

    public CassandraSQLContext GetCassandraSQLContext() {
        SparkContext sc = new SparkContext(conf);
        sqlContext = new CassandraSQLContext(sc);
        return sqlContext;
    }
}
