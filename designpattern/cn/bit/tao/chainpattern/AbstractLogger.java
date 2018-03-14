package cn.bit.tao.chainpattern;

/*
 * @author Tao wenjun
 * @Date 2018/03/14
 * 记录器抽象类
 */
public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;
    public int level;
    private AbstractLogger nextLogger;

    //设置下一个节点
    public void setNextLogger(AbstractLogger nextLogger){
    	this.nextLogger=nextLogger;
    }

    //记录信息
    public void logMessage(int level,String message){
    	if(this.level <= level){
    		write(message);
    	}
    	if(nextLogger!=null){
    		nextLogger.logMessage(level, message);
    	}
    }
    
    //打印信息
    abstract protected void write(String message);

}
