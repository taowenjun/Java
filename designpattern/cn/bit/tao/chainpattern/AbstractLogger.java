package cn.bit.tao.chainpattern;

/*
 * @author Tao wenjun
 * @Date 2018/03/14
 * ��¼��������
 */
public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;
    public int level;
    private AbstractLogger nextLogger;

    //������һ���ڵ�
    public void setNextLogger(AbstractLogger nextLogger){
    	this.nextLogger=nextLogger;
    }

    //��¼��Ϣ
    public void logMessage(int level,String message){
    	if(this.level <= level){
    		write(message);
    	}
    	if(nextLogger!=null){
    		nextLogger.logMessage(level, message);
    	}
    }
    
    //��ӡ��Ϣ
    abstract protected void write(String message);

}
