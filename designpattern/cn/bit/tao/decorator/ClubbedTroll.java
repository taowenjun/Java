package cn.bit.tao.decorator;

/**
 * ClubbedTroll��װ���߸�troll�����һ��club
 * @author Tao Wenjun
 * @date 2018��5��29��
 */
public class ClubbedTroll implements Troll {
	
	private Troll decorated;
	
	public ClubbedTroll(Troll decorated) {
		this.decorated = decorated;
	}

	@Override
	public void attack() {
		decorated.attack();
		System.out.println("The troll swings at you with a club!");
	}

	@Override
	public int getAttackPower() {
		return decorated.getAttackPower()+10;
	}

	@Override
	public void fleeBattle() {
		decorated.fleeBattle();
	}

}
