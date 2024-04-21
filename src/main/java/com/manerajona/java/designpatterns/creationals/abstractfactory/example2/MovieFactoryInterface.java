package com.manerajona.java.designpatterns.creationals.abstractfactory.example2;

interface MovieFactoryInterface {
    HollyWoodMovieInterface getHollyWoodMovie(MovieType type);

    BollyWoodMovieInterface getBollyWoodMovie(MovieType type);
}

class HollyWoodMovieFactory implements MovieFactoryInterface {
    public HollyWoodMovieInterface getHollyWoodMovie(MovieType type) {
        return switch (type) {
            case ACTION -> new HollyWoodActionMovie();
            case COMEDY -> new HollyWoodComedyMovie();
        };
    }

    public BollyWoodMovieInterface getBollyWoodMovie(MovieType type) {
        return null;
    }
}

class BollyWoodMovieFactory implements MovieFactoryInterface {
    public HollyWoodMovieInterface getHollyWoodMovie(MovieType type) {
        return null;
    }

    public BollyWoodMovieInterface getBollyWoodMovie(MovieType type) {
        return switch (type) {
            case ACTION -> new BollyWoodActionMovie();
            case COMEDY -> new BollyWoodComedyMovie();
        };
    }
}