package cn.bit.tao.factory;

import cn.bit.tao.factory.shape.Shape;

public class FactoryPatternDemo {

	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		
		//��ȡCircle���󣬲�������draw()����
		Shape circle = factory.getShape("circle");
		
		circle.draw();
		
		//��ȡSquare���󣬲�������draw()����
		Shape square = factory.getShape("square");
		
		square.draw();
		
		//��ȡRectangle���󣬲�������draw()����
		Shape rectangle = factory.getShape("rectangle");
		
		rectangle.draw();
	}
}
