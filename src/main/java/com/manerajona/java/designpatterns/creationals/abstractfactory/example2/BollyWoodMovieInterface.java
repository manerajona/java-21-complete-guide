package com.manerajona.java.designpatterns.creationals.abstractfactory.example2;

interface BollyWoodMovieInterface {
    String getMovieName();
}

class BollyWoodActionMovie implements BollyWoodMovieInterface {
    @Override
    public String getMovieName() {
        return "Bang Bang is a Bollywood Action Movie";
    }
}

class BollyWoodComedyMovie implements BollyWoodMovieInterface {
    @Override
    public String getMovieName() {
        return "Munna Bhai MBBS is a Bollywood Comedy Movie";
    }
}