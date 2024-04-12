package com.manerajona.java.programming.oop.polimorfism;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Movie movie = randomMovie();
            System.out.println(movie.getName() + "\n Plot:" + movie.plot());
        }

    }

    public static Movie randomMovie() {
        int rnd = (int) (Math.random() * 4);
        switch (rnd) {
            case 1:
                return new Jaws();
            case 2:
                return new IndependenceDay();
            case 3:
                return new MazeRunner();
            default:
                return new ForgettableMovie();
        }
    }
}

class Movie {
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String plot() {
        return "Not plot here";
    }

    public String getName() {
        return name;
    }
}

class Jaws extends Movie {

    public Jaws() {
        super("Jaws");
    }

    public String plot() {
        return "A sharks eats lots of people";
    }
}

class IndependenceDay extends Movie {
    public IndependenceDay() {
        super("Independence Day");
    }

    public String plot() {
        return "Aliens attempt to take over the planet earth";
    }
}

class MazeRunner extends Movie {

    public MazeRunner() {
        super("Maze Runner");
    }

    public String plot() {
        return "Kids try to escape  a maze";
    }
}

class ForgettableMovie extends Movie {
    public ForgettableMovie() {
        super("Forgettable");
    }
}
