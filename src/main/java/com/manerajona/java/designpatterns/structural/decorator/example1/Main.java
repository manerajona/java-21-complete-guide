package com.manerajona.java.designpatterns.structural.decorator.example1;

public class Main {
    public static void main(String[] args) {

        ConcreteComponent cc = new ConcreteComponent();

        ConcreteDecoratorExOne cdOne = new ConcreteDecoratorExOne();

        // Decorating ConcreteComponent Object cc with ConcreteDecoratorEx_1
        cdOne.setTheComponent(cc);
        cdOne.doJob();

        ConcreteDecoratorExTwo cdTwo = new ConcreteDecoratorExTwo();

        // Decorating ConcreteComponent Object cc with ConcreteDecoratorEx_1 & ConcreteDecoratorEX_2
        cdTwo.setTheComponent(cdOne);//Adding results from cdOne now
        cdTwo.doJob();
    }
}
