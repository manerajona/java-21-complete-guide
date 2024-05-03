package com.manerajona.java.designpatterns.structural.flyweight.example1;

interface RobotInterface {
    void print();

    // extrinsic data is passed as arguments
    void setColor(String colorOfRobot);
}

class Robot implements RobotInterface {

    private final RobotType robotType;
    private String colorOfRobot;

    public Robot(RobotType robotType) {
        this.robotType = robotType;
    }

    /**
     * @param colorOfRobot is the Extrinsic State
     */
    public void setColor(String colorOfRobot) {
        this.colorOfRobot = colorOfRobot;
    }

    @Override
    public void print() {
        System.out.printf("This is a %s type robot with %s color %n", robotType, colorOfRobot);
    }
}


