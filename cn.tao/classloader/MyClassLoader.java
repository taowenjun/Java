package cn.tao.classloader;

import java.io.IOException;

/**
 * @Author taowenjun
 * @Date 2019/4/11.
 */
public class MyClassLoader extends ClassLoader {
    private static final String BASE_DIR = "C:\\Users\\taowenjun\\IdeaProjects\\HelloJava\\out\\production\\HelloJava\\";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = name.replaceAll("\\.", "/");
        fileName = BASE_DIR + fileName + ".class";

        try {
            byte[] bytes = BinaryFileUtils.readFileToByteArray(fileName);
            return defineClass(name,bytes,0,bytes.length);
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return null;
    }
}
