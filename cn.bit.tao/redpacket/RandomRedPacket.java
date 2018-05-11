package cn.bit.tao.redpacket;

import java.util.Random;

/**
 * 抢红包
 * @author Tao Wenjun
 * @date 2018年5月11日
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
	 * 抢红包实现方法
	 * @return 抢到的红包钱数
	 */
	public synchronized int nextMoney(){
		if(this.leftNum<=0){
			try {
				throw new IllegalAccessException("抢光了");
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
