package cn.bit.tao.factory.entity;

import cn.bit.tao.factory.shape.Shape;

public class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}

}
