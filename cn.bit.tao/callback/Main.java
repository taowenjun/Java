package cn.bit.tao.callback;

/**
 * ���Իص�����
 * @author Tao Wenjun
 * @date 2018��7��13��
 */
public class Main {

	public static void main(String[] args) {
		
		String task = "�����ļ�";
		
		Manager manager = new Manager();
		//��Ա����������
		manager.assignTask(new Personnel(), task);
		
	}

}
