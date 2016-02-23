package com.tortilla.db;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.cassandra.CassandraSQLContext;

import java.util.List;

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
    private String cassandrahost;

    public String getCassandrahost() {
        return cassandrahost;
    }

    public void setCassandrahost(String cassandrahost) {
        this.cassandrahost = cassandrahost;
    }

    public SparkCassandraConnector() {
        //following 2 lines connect to spark and cassandra from google cloud respectively.
        conf = new SparkConf().setAppName("spark example").setMaster("local")  ;
        conf.set("spark.cassandra.connection.host", cassandrahost); //"146.148.48.21"
        conf.set("spark.driver.allowMultipleContexts", String.valueOf(true));
    }

    public SparkCassandraConnector(String cassandrahost) {
        //following 2 lines connect to spark and cassandra from google cloud respectively.
        conf = new SparkConf().setAppName("spark example").setMaster("local")  ;
        conf.set("spark.cassandra.connection.host", cassandrahost); //"146.148.48.21"
        conf.set("spark.driver.allowMultipleContexts", String.valueOf(true));
    }

    public CassandraSQLContext GetCassandraSQLContext() {
        try {
            SparkContext sc = new SparkContext(conf);
            sqlContext = new CassandraSQLContext(sc);
        }catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return sqlContext;
    }

}


