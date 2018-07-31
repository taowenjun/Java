package cn.bit.tao.reflect;

/**
 * @Author taowenjun
 * @Date 2018/7/31.
 */
public class Quizzee {
    public void testMethod(String arg1,Integer arg2){
        System.out.println("测试结果：反射方法的调用");
        System.out.println(arg1+" "+arg2);
        System.out.println("测试成功");
    }
}
