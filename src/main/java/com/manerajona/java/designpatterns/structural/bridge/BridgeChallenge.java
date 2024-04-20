package com.manerajona.java.designpatterns.structural.bridge;

interface Renderers {
    public String whatToRenderAs();
}

abstract class Shapes {
    private Renderers renderer;
    public String name;

    public Shapes(Renderers renderer) {
        this.renderer = renderer;
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as %s",
                name, renderer.whatToRenderAs());
    }
}

class Triangle extends Shapes {
    public Triangle(Renderers renderer) {
        super(renderer);
        name = "Triangle";
    }
}

class Square extends Shapes {
    public Square(Renderers renderer) {
        super(renderer);
        name = "Square";
    }
}

class RasterRenderers implements Renderers {

    @Override
    public String whatToRenderAs() {
        return "pixels";
    }
}

class VectorRenderers implements Renderers {
    @Override
    public String whatToRenderAs() {
        return "lines";
    }
}