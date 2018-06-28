package cn.bit.tao.adapter;
/**
 *@author  tao wenjun
 *@date 2018Äê6ÔÂ28ÈÕ
 *
 */

public class Captain {

	private RowingBoat rowingBoat;
	
	public Captain(){
		
	}
	
	public Captain(RowingBoat rowingBoat){
		this.rowingBoat = rowingBoat;
	}
	
	public void row(){
		rowingBoat.row();
	}
}
