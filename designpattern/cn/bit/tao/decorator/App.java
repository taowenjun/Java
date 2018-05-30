package cn.bit.tao.decorator;

/**
 * ����װ����ģʽ
 * @author Tao Wenjun
 * @date 2018��5��29��
 */
public class App {

	public static void main(String[] args) {
		System.out.println("A simple looking troll approaches.");
		Troll troll = new SimpleTroll();
		troll.attack();
		troll.fleeBattle();
		System.out.println("Simple troll power "+troll.getAttackPower()+".");
		
		System.out.println();
		
		//ͨ��װ���߸ı�troll����Ϊ
		System.out.println("A troll with huge club surprises you.");
		troll = new ClubbedTroll(troll);
		troll.attack();
		troll.fleeBattle();
		System.out.println("Clubbed troll power "+troll.getAttackPower()+".");
	}

}
