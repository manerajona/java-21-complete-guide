package com.manerajona.java.designpatterns.creationals.prototype.example1;

import java.util.HashMap;
import java.util.Map;

class ShapeCache {

    private static final Map<String, Shape> shapeMap = new HashMap<>();

    private ShapeCache() {
    }

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}