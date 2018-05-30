package cn.bit.tao.decorator;

/**
 * 测试装饰着模式
 * @author Tao Wenjun
 * @date 2018年5月29日
 */
public class App {

	public static void main(String[] args) {
		System.out.println("A simple looking troll approaches.");
		Troll troll = new SimpleTroll();
		troll.attack();
		troll.fleeBattle();
		System.out.println("Simple troll power "+troll.getAttackPower()+".");
		
		System.out.println();
		
		//通过装饰者改变troll的行为
		System.out.println("A troll with huge club surprises you.");
		troll = new ClubbedTroll(troll);
		troll.attack();
		troll.fleeBattle();
		System.out.println("Clubbed troll power "+troll.getAttackPower()+".");
	}

}
