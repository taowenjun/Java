package cn.bit.tao.decorator;

/**
 * ClubbedTroll：装饰者给troll添加了一个club
 * @author Tao Wenjun
 * @date 2018年5月29日
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
