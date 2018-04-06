package cn.bit.tao.factory.entity;

import cn.bit.tao.factory.shape.Shape;

public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}
