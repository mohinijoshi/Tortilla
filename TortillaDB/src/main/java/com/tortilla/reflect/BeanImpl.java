package com.tortilla.reflect;

/**
 * Created with IntelliJ IDEA.
 * User: uttam
 * Date: 2/27/16
 * Time: 6:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class BeanImpl implements Bean {

    public boolean someMethod() {
        return false;
    }

    public boolean someMethod(String arg) {
        return "true".equals(arg);
    }
}
