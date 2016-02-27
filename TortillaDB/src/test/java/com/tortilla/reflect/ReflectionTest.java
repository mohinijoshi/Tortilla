package com.tortilla.reflect;

import junit.framework.TestCase;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: uttam
 * Date: 2/27/16
 * Time: 6:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReflectionTest extends TestCase {

     public void testBean() throws Exception {
         Class clazz = Class.forName("com.tortilla.reflect.Bean");

         introspect(clazz);

         introspect(Class.forName("com.tortilla.reflect.BeanImpl"));

         BeanImpl bean = new BeanImpl();
         System.out.println(clazz.getMethod("someMethod").invoke(bean));

         System.out.println(clazz.getMethod("someMethod", String.class).invoke(bean, "true"));

         Bean proxy = (Bean)ProxyHandler.newInstance(Bean.class, bean);
         assertEquals("true", proxy.someMethod("true"));

     }

    private void introspect(Class clazz) {
        System.out.println("==========================");
        for(Method method : clazz.getDeclaredMethods()) {
            System.out.println(method);
        }
        System.out.println("--------------------------");

        for(Method method : clazz.getMethods()) {
            System.out.println(method);
        }
        System.out.println("--------------------------");

        for(Field field : clazz.getDeclaredFields()) {
            System.out.println(field);
        }
        System.out.println("==========================");
    }

}
