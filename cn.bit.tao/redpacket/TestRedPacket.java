package cn.bit.tao.redpacket;

/**
 * 测试抢红包
 * @author Tao Wenjun
 * @date 2018年5月11日
 */
public class TestRedPacket {

	public static void main(String[] args) {
		RandomRedPacket ran = new RandomRedPacket(1000,10);
		for(int i=0;i<10;i++){
			System.out.println(ran.nextMoney());
		}
	}

}
