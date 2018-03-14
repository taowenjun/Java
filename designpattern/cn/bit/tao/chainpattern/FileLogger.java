package cn.bit.tao.chainpattern;
/*
 * @author Tao wenjun
 * @Date 2018/03/14
 * ÎÄ¼þ¼ÇÂ¼Æ÷
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
    	this.level = level;
    }

	@Override
	protected void write(String message) {
		System.out.println("File::Logger:"+message);
	}  
}
