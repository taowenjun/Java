package cn.bit.tao.commandpattern;

import cn.bit.tao.commandpattern.command.Broker;
import cn.bit.tao.commandpattern.entity.BuyStock;
import cn.bit.tao.commandpattern.entity.SellStock;
import cn.bit.tao.commandpattern.request.Stock;

/** 
 * @author Tao wenjun
 * 命令模式
 */
public class CommandPatternDemo {

	public static void main(String[] args) {
		Stock abcStock = new Stock("ABC",10);
		
		//命令
		BuyStock buyStockOrder = new BuyStock(abcStock);
		SellStock sellStokOrder = new SellStock(abcStock);
		
		//代理
		Broker broker = new Broker();
		broker.takeOrder(sellStokOrder);
		broker.takeOrder(buyStockOrder);
		
		broker.placeOrders();

	}

}
