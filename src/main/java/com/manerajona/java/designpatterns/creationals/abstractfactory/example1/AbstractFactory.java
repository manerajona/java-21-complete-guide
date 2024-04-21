package com.manerajona.java.designpatterns.creationals.abstractfactory.example1;

import javax.annotation.Nullable;

public abstract class AbstractFactory {

    @Nullable
    abstract Color getColor(ColorType colorType);

    @Nullable
    abstract Shape getShape(ShapeType shapeType);
}

class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(ShapeType shapeType) {
        return switch (shapeType) {
            case CIRCLE -> new Circle();
            case RECTANGLE -> new Rectangle();
            case SQUARE -> new Square();
        };
    }

    @Override
    Color getColor(ColorType colorType) {
        return null;
    }

}

class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(ShapeType shapeType) {
        return null;
    }

    @Override
    Color getColor(ColorType colorType) {
        return switch (colorType) {
            case RED -> new Red();
            case GREEN -> new Green();
            case BLUE -> new Blue();
        };
    }
}