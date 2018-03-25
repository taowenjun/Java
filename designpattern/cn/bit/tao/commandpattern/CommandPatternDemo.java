package cn.bit.tao.commandpattern;

import cn.bit.tao.commandpattern.command.Broker;
import cn.bit.tao.commandpattern.entity.BuyStock;
import cn.bit.tao.commandpattern.entity.SellStock;
import cn.bit.tao.commandpattern.request.Stock;

/** 
 * @author Tao wenjun
 * ����ģʽ
 */
public class CommandPatternDemo {

	public static void main(String[] args) {
		Stock abcStock = new Stock("ABC",10);
		
		//����
		BuyStock buyStockOrder = new BuyStock(abcStock);
		SellStock sellStokOrder = new SellStock(abcStock);
		
		//����
		Broker broker = new Broker();
		broker.takeOrder(sellStokOrder);
		broker.takeOrder(buyStockOrder);
		
		broker.placeOrders();

	}

}
