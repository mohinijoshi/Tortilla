package com.tortilla.db;

/**
 * Created by Mohini on 2/11/2016.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MainApp implements Runnable {
    private Thread t;
    private String threadName;
    enum juicePacketSize {small, medium, large}
        private  juicePacketSize juicepackets;

    public MainApp(String name){
         threadName = name;
    }
    public void run() {
        try {
        for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            Thread.sleep(50);
              }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void start(){
           System.out.println("started thread:" + threadName);
            if(t == null) {
               t = new Thread(this,threadName);
               t.start();
            }
    }

    public static void main(String[] args) {
        /*
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        SparkCassandraConnector objA = (SparkCassandraConnector) context.getBean("helloWorld");
        objA.setCassandrahost("52.36.13.56");
        objA.GetCassandraSQLContext();
        */

                 System.out.println(juicePacketSize.medium);
        try
        {
        java.io.File file = new java.io.File("C:\\Users\\uttam\\Desktop\\Misc\\aunty.txt");
        String infile = file.getAbsolutePath();
        java.io.File file1 = new java.io.File("C:\\Users\\uttam\\Desktop\\Misc\\aunty1.txt");
        String outfile = file1.getAbsolutePath();
        java.io.FileInputStream inputStream = new FileInputStream(file);
        java.io.FileOutputStream outputStream = new FileOutputStream(file1);
        int c;
        while(( c = inputStream.read()) != -1){
                outputStream.write(c);
        }
            /*
            MainApp thread1 = new MainApp("thread1");
            thread1.start();

            MainApp thread2 = new MainApp("thread2");
            thread2.start();
             */
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        java.util.ArrayList al = new ArrayList();
        al.add("utts");
        al.add("mj");
        al.add("np");
        al.add("rt");

        Iterator itr1 = al.iterator();
        while(itr1.hasNext()) {
            System.out.println(itr1.next());
        }
    }
}