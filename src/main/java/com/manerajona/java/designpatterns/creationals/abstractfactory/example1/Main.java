package com.manerajona.java.designpatterns.creationals.abstractfactory.example1;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //Shape factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory(FactoryProducer.Type.SHAPE);
        Optional.ofNullable(shapeFactory.getShape(ShapeType.CIRCLE)).ifPresent(Shape::draw);
        Optional.ofNullable(shapeFactory.getShape(ShapeType.RECTANGLE)).ifPresent(Shape::draw);
        Optional.ofNullable(shapeFactory.getShape(ShapeType.SQUARE)).ifPresent(Shape::draw);

        //Color factory
        AbstractFactory colorFactory = FactoryProducer.getFactory(FactoryProducer.Type.COLOR);
        Optional.ofNullable(colorFactory.getColor(ColorType.RED)).ifPresent(Color::fill);
        Optional.ofNullable(colorFactory.getColor(ColorType.GREEN)).ifPresent(Color::fill);
        Optional.ofNullable(colorFactory.getColor(ColorType.BLUE)).ifPresent(Color::fill);
    }
}