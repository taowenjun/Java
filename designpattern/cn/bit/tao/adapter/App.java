package cn.bit.tao.adapter;
/**
 *@author  tao wenjun
 *@date 2018��6��28��
 *
 */

public class App {

	public static void main(String[] args) {
		Captain captain = new Captain(new FishingBoatAdapter());
		captain.row();
	}

}
