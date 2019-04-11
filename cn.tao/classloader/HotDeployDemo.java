package cn.tao.classloader;

import cn.tao.classloader.loaddir.IHelloService;

import java.io.File;

/**
 * @Author taowenjun
 * @Date 2019/4/11.
 */
public class HotDeployDemo {
    private static final String CLASS_NAME = "cn.tao.classloader.loaddir.HelloImpl";
    private static final String FILE_NAME = "C:\\Users\\taowenjun\\IdeaProjects\\HelloJava\\out\\production\\HelloJava\\"+CLASS_NAME.replaceAll("\\.","/")+".class";
    private static volatile IHelloService helloService;

    public static IHelloService getHelloService(){
        if(helloService!=null){
            return helloService;
        }
        synchronized (HotDeployDemo.class){
            if(helloService==null){
                helloService = createHelloService();
            }
            return helloService;
        }
    }

    private static IHelloService createHelloService(){

        try {
            //System.out.println("create new instance");
            MyClassLoader cl = new MyClassLoader();
            Class<?> cls = cl.findClass(CLASS_NAME);
            if(cls!=null){
                return (IHelloService)cls.newInstance();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void client(){
        Thread t = new Thread(){
            @Override
            public void run() {
                while(true){
                    try {
                        IHelloService helloService = getHelloService();
                        if(helloService!=null){
                            helloService.sayHello();
                        }
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }

    public static void monitor(){
        Thread t = new Thread(){
            private long lastModified = new File(FILE_NAME).lastModified();
            @Override
            public void run() {
                try{
                    while(true){
                        Thread.sleep(100);
                        //System.out.println("last:"+lastModified);
                        long now = new File(FILE_NAME).lastModified();
                        //System.out.println("now:"+now);
                        if(now!=lastModified){
                            reloadHelloService();
                            lastModified = now;
                        }
                    }
                }catch(Exception e){

                }
            }
        };
        t.start();
    }

    public static void reloadHelloService(){
        helloService = createHelloService();
        System.out.println("reload");
    }

    public static void main(String[] args){
        monitor();
        client();
    }
}
