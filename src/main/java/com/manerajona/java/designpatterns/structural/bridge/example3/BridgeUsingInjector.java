package com.manerajona.java.designpatterns.structural.bridge.example3;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;

interface Renderer {
    void renderCircle(float radius);
}

class VectorRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle of radius " + radius);
    }
}

class RasterRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing pixels for a circle of radius " + radius);
    }
}

abstract class Shape {

    protected Renderer renderer;

    protected Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();

    public abstract void resize(float factor);
}

class Circle extends Shape {

    private float radius;

    @Inject
    public Circle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }

    @Override
    public void resize(float factor) {
        radius *= factor;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}

class ShapeModule extends AbstractModule {
    @Override
    protected void configure() {
        //bind(Renderer.class).to(VectorRenderer.class);
        bind(Renderer.class).to(RasterRenderer.class);
    }
}
