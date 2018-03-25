package cn.bit.tao.commandpattern.entity;

import cn.bit.tao.commandpattern.order.IOrder;
import cn.bit.tao.commandpattern.request.Stock;
/** 
 * @author Tao wenjun
 * sell√¸¡Ó¿‡
 */
public class SellStock implements IOrder {
    private Stock abcStock;
	
	public SellStock(Stock abcStock){
		this.abcStock=abcStock;
	}
	@Override
	public void execute() {
		abcStock.sell();
	}

}
