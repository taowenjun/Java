package cn.bit.tao.factory;

import cn.bit.tao.factory.entity.Circle;
import cn.bit.tao.factory.entity.Rectangle;
import cn.bit.tao.factory.entity.Square;
import cn.bit.tao.factory.shape.Shape;

public class ShapeFactory {
	public Shape getShape(String shapeType){
		if(shapeType==null){
			return null;
		}
		if(shapeType.equalsIgnoreCase("CIRCLE")){
			return new Circle();
		}else if(shapeType.equalsIgnoreCase("RECTANGLE")){
			return new Rectangle();
		}else if(shapeType.equalsIgnoreCase("SQUARE")){
			return new Square();
		}
		return null;
	}
}
