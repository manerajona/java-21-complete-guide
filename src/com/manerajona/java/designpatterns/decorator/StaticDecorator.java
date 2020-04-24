package com.manerajona.java.designpatterns.decorator;

import java.util.function.Supplier;

class StaticDecorator {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        System.out.println(circle.info());

        ColoredStaticShape<Square> blueSquare = new ColoredStaticShape<>(() -> new Square(20), "blue");
        System.out.println(blueSquare.info());

        // ugly!
        TransparentStaticShape<ColoredStaticShape<Circle>> myCircle =
                new TransparentStaticShape<>(
                        () -> new ColoredStaticShape<>(
                                () -> new Circle(5), "green"
                        ), 50
                );
        System.out.println(myCircle.info());

        // cannot call myCircle.resize()
    }
}

// we are NOT altering the base class of these objects
// cannot make ColoredSquare, ColoredCircle

class ColoredStaticShape<T extends Shape> implements Shape {
    private Shape shape;
    private String color;

    public ColoredStaticShape(Supplier<? extends T> ctor, String color) {
        shape = ctor.get(); // Initialize shape, using an unknown constructor
        this.color = color;
    }

    @Override
    public String info() {
        return shape + " has the color " + color;
    }
}

class TransparentStaticShape<T extends Shape> implements Shape {
    private Shape shape;
    private int transparency;

    public TransparentStaticShape(Supplier<? extends T> ctor, int transparency) {
        shape = ctor.get(); // Initialize shape, using an unknown constructor
        this.transparency = transparency;
    }

    @Override
    public String info() {
        return shape + " has " + transparency + "% transparency";
    }
}
