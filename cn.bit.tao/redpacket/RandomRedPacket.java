package cn.bit.tao.redpacket;

import java.util.Random;

/**
 * �����
 * @author Tao Wenjun
 * @date 2018��5��11��
 */
public class RandomRedPacket {
	
	private int leftMoney;
	private int leftNum;
	private Random rnd;
	
	public RandomRedPacket(int total,int num){
		this.leftMoney=total;
		this.leftNum=num;
		this.rnd=new Random();
	}
	
	/**
	 * �����ʵ�ַ���
	 * @return �����ĺ��Ǯ��
	 */
	public synchronized int nextMoney(){
		if(this.leftNum<=0){
			try {
				throw new IllegalAccessException("������");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(this.leftNum==1){
			return this.leftMoney;
		}
		
		double max = this.leftMoney/this.leftNum*2d;
		int money = (int)(rnd.nextDouble()*max);
		money = Math.max(1, money);
		this.leftMoney-=money;
		this.leftNum--;
		return money;
	}
}
