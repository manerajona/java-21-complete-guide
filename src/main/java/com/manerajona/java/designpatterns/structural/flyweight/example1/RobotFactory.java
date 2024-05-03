package com.manerajona.java.designpatterns.structural.flyweight.example1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class RobotFactory {

    Map<RobotType, RobotInterface> shapes = new ConcurrentHashMap<>();

    public int totalObjectsCreated() {
        return shapes.size();
    }

    public RobotInterface getRobotFromFactory(RobotType robotType) {
        RobotInterface myRobot;
        if (shapes.containsKey(robotType)) {
            myRobot = shapes.get(robotType);
        } else {
            System.out.printf("%n We do not have a %s Robot. So we are creating a new one.%n", robotType);
            myRobot = new Robot(robotType);
            shapes.put(robotType, myRobot);
        }
        return myRobot;
    }
}

