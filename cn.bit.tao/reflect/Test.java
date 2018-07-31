package cn.bit.tao.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author taowenjun
 * @Date 2018/7/31.
 */
public class Test {

    public static void main(String[] args) {
        Object object = null;
        try {
            object = Class.forName("cn.bit.tao.reflect.Quizzee").newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Method method = null;
        try {
            method = object.getClass().getMethod("testMethod",new Class[]{String.class,Integer.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            method.invoke(object,new Object[]{new String("yes"),100});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
