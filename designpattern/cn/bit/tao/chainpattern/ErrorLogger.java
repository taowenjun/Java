package cn.bit.tao.chainpattern;
/*
 * @author Tao wenjun
 * @Date 2018/03/14
 * �����¼����
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
    	this.level = level;
    }

	@Override
	protected void write(String message) {
		System.out.println("Error Console::Logger:"+message);
	}    
}
