package cn.bit.tao.adapter;
/**
 *@author  tao wenjun
 *@date 2018Äê6ÔÂ28ÈÕ
 *
 */

public class FishingBoatAdapter implements RowingBoat {
	
	private FishingBoat boat;

	public FishingBoatAdapter() {
		boat = new FishingBoat();
	}
	
	@Override
	public void row() {
		boat.sail();
	}

}
