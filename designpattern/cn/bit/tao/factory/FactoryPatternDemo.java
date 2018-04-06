package cn.bit.tao.factory;

import cn.bit.tao.factory.shape.Shape;

public class FactoryPatternDemo {

	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		
		//获取Circle对象，并调用其draw()方法
		Shape circle = factory.getShape("circle");
		
		circle.draw();
		
		//获取Square对象，并调用其draw()方法
		Shape square = factory.getShape("square");
		
		square.draw();
		
		//获取Rectangle对象，并调用其draw()方法
		Shape rectangle = factory.getShape("rectangle");
		
		rectangle.draw();
	}
}
