package cn.bit.tao.adapter;
/**
 *@author  tao wenjun
 *@date 2018��6��28��
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
