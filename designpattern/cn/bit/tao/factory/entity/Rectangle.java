package cn.bit.tao.factory.entity;

import cn.bit.tao.factory.shape.Shape;
/**
 * @author Tao wenjun
 * Rectangle
 */
public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}
