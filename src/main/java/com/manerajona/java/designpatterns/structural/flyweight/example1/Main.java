package com.manerajona.java.designpatterns.structural.flyweight.example1;

import java.util.Random;

public class Main {

    static final Random RANDOM = new Random();
    static final RobotFactory ROBOT_FACTORY = new RobotFactory();

    static String getRandomColor() {
        /*You can supply any number of your choice in nextInt argument.
         * we are simply checking the random number generated is an even number
         * or an odd number. And based on that we are choosing the color.
         * For simplicity, we’ll use only two colors—red and green
         */
        int random = RANDOM.nextInt(20);
        return (random % 2 == 0) ? "red" : "green";
    }

    public static void main(String[] args) {

        RobotFactory factory = ROBOT_FACTORY;

        Robot shape;

        /*Here we are trying to get 3 king type robots*/
        for (int i = 0; i < 3; i++) {
            shape = (Robot) factory.getRobotFromFactory(RobotType.KING);
            shape.setColor(getRandomColor());
            shape.print();
        }

        /*Here we are trying to get 3 queen type robots*/
        for (int i = 0; i < 3; i++) {
            shape = (Robot) factory.getRobotFromFactory(RobotType.QUEEN);
            shape.setColor(getRandomColor());
            shape.print();
        }

        int numOfDistinctRobots = factory.totalObjectsCreated();
        System.out.println("\n Finally no of Distinct Robot objects created: " + numOfDistinctRobots);
    }
}