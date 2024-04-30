package com.manerajona.java.designpatterns.structural.decorator.example1;

abstract class AbstractDecorator implements Component {
    protected Component component;

    public void setTheComponent(Component component) {
        this.component = component;
    }

    public void doJob() {
        if (component != null) {
            component.doJob();
        }
    }
}

class ConcreteDecoratorExOne extends AbstractDecorator {

    @Override
    public void doJob() {

        super.doJob();

        // add additional responsibilities
        System.out.println("I am explicity from Ex_1");
    }
}

class ConcreteDecoratorExTwo extends AbstractDecorator {

    @Override
    public void doJob() {
        System.out.println();
        System.out.println("***START Ex-2***");

        super.doJob();

        //Add additional thing if necessary
        System.out.println("Explicitly From DecoratorEx_2");
        System.out.println("***END. EX-2***");
    }
}