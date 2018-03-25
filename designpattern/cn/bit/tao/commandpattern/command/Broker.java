package cn.bit.tao.commandpattern.command;

import java.util.ArrayList;
import java.util.List;

import cn.bit.tao.commandpattern.order.IOrder;
/** 
 * @author Tao wenjun
 * ÃüÁî´úÀíÀà
 */
public class Broker {
	private List<IOrder> orderList = new ArrayList<>();
	
	public void takeOrder(IOrder order){
		orderList.add(order);
	}
	
	public void placeOrders(){
		for(IOrder order:orderList){
			order.execute();
		}
		orderList.clear();
	}
}
