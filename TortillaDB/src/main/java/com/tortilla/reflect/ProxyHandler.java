package com.tortilla.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: uttam
 * Date: 2/27/16
 * Time: 6:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProxyHandler implements java.lang.reflect.InvocationHandler {

    private Object obj;

    public static Object newInstance(Class intrface, Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                new Class[]{intrface},//obj.getClass().getInterfaces(),
                new ProxyHandler(obj));
    }

    private ProxyHandler(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method m, Object[] args)
            throws Throwable
    {
        Object result;
        try {
            System.out.println("before method " + m.getName());
            result = m.invoke(obj, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " +
                    e.getMessage());
        } finally {
            System.out.println("after method " + m.getName());
        }
        return result;
    }
}
