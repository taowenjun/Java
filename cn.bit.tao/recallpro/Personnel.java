package cn.bit.tao.recallpro;

/**
 * ����ģ��Ա����
 * @author Tao Wenjun
 * @date 2018��7��13��
 */
public class Personnel {
	
	/**
	 * �ɻ�ķ���
	 * @param manager����������ľ���
	 * @param task�����õ�����
	 */
	public void doSomething(Manager manager,String task){
		
		//�ܾ���ͨ������Personnel�ĸ÷�������Ա����ʲô
		System.out.println("      Ա�����ܾ���Ҫ����"+task);
		
		//�ɻ�
		System.out.println("      Ա������ʼ�ɻ�");
		try {
			System.out.println("      Ա�����ɻ�ing������");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("      Ա�����������");
		String result = "������";
		System.out.println("      Ա������绰���ܾ���"+task +" "+ result);
		//�����������˾�ͨ���ܾ�������phoneCall����֪ͨ�ܾ�����
		manager.phoneCall(task +" "+ result);
	}
}
