package cn.bit.tao.decorator;

/**
 * SimpleTroll ֱ��ʵ����{@link Troll}�ӿ�
 * @author Tao Wenjun
 * @date 2018��5��29��
 */

public class SimpleTroll implements Troll {

	@Override
	public void attack() {
		System.out.println("The troll tries to grab you!");
	}

	@Override
	public int getAttackPower() {
		return 10;
	}

	@Override
	public void fleeBattle() {
		System.out.println("The troll shrieks in horror and runs away!");
	}

}
