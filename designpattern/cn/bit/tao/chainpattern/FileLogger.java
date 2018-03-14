package cn.bit.tao.chainpattern;
/*
 * @author Tao wenjun
 * @Date 2018/03/14
 * �ļ���¼��
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
