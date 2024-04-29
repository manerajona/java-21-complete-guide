package com.manerajona.java.designpatterns.structural.composite.example3;

public class Main {
    public static void main(String[] args) {

        GraphicObject drawing = new GraphicObject();
        drawing.setName("My Drawing");

        drawing.children.add(new Square("Red"));
        drawing.children.add(new Circle("Yellow"));

        GraphicObject group = new GraphicObject();
        group.children.add(new Circle("Blue"));
        group.children.add(new Square("Blue"));
        drawing.children.add(group);

        System.out.println(drawing);
    }
}
