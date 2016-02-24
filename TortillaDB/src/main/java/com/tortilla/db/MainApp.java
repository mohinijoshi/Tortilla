package com.tortilla.db;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mohini on 2/11/2016.
 */
public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        SparkCassandraConnector objA = (SparkCassandraConnector) context.getBean("helloWorld");
        objA.setCassandrahost("52.36.13.56");
        objA.GetCassandraSQLContext();

    }
}
