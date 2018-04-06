package cn.bit.tao.factory.entity;

import cn.bit.tao.factory.shape.Shape;
/**
 * @author Tao wenjun
 * Circle
 */
public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}

}
