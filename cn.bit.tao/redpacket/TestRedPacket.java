package cn.bit.tao.redpacket;

/**
 * ���������
 * @author Tao Wenjun
 * @date 2018��5��11��
 */
public class TestRedPacket {

	public static void main(String[] args) {
		RandomRedPacket ran = new RandomRedPacket(1000,10);
		for(int i=0;i<10;i++){
			System.out.println(ran.nextMoney());
		}
	}

}
