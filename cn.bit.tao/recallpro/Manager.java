package cn.bit.tao.recallpro;

/**
 * ����ģ���ܾ���
 * @author Tao Wenjun
 * @date 2018��7��13��
 */
public class Manager {
	
	public Manager(){
		
	}
	
	/**
	 * ��Ա���������񷽷�
	 * @param personnel���ɻ��Ա��
	 * @param task����������
	 */
	public void assignTask(Personnel personnel,String task){
		System.out.println("�ܾ�����Ա����������");
		personnel.doSomething(this, task);
	}
	
	/**
	 * �ܾ������ϵ��ʽ
	 * @param result
	 */
	public void phoneCall(String result){
		System.out.print(" �ܾ����ӵ��绰������֪Ա���Ĺ��������");
		System.out.println(result);
	}
}
