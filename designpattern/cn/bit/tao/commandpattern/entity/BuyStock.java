package cn.bit.tao.commandpattern.entity;

import cn.bit.tao.commandpattern.order.IOrder;
import cn.bit.tao.commandpattern.request.Stock;
/** 
 * @author Tao wenjun
 * buy√¸¡Ó¿‡
 */
public class BuyStock implements IOrder {
	private Stock abcStock;
	
	public BuyStock(Stock abcStock){
		this.abcStock=abcStock;
	}
	
	@Override
	public void execute() {
		abcStock.buy();
	}

}
