package cn.tao.exchanger;

import java.util.concurrent.Exchanger;

/**
 *@author  tao wenjun
 *@date 2018Äê4ÔÂ28ÈÕ
 *
 */

public class Run {

	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();
		ThreadA threadA = new ThreadA(exchanger);
		ThreadB threadB = new ThreadB(exchanger);
		threadA.start();
        threadB.start();
	}

}
