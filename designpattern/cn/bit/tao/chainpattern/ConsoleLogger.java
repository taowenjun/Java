package cn.bit.tao.chainpattern;
/*
 * @author Tao wenjun
 * @Date 2018/03/14
 * 控制台记录器类
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
    	this.level = level;
    }

	@Override
	protected void write(String message) {
		System.out.println("Standard Console::Logger:"+message);
	}
}
