package com.manerajona.java.designpatterns.creationals.abstractfactory.example2;

public class Main {
    public static void main(String[] args) {
        MovieFactoryInterface hollyWoodMovieFactory = FactoryProducer.getFactory(FactoryProducer.Type.HOLLYWOOD);

        HollyWoodMovieInterface hAction = hollyWoodMovieFactory.getHollyWoodMovie(MovieType.ACTION);
        HollyWoodMovieInterface hComedy = hollyWoodMovieFactory.getHollyWoodMovie(MovieType.COMEDY);

        System.out.println("\nHollyWood movies  are:");
        System.out.println(hAction.getMovieName());
        System.out.println(hComedy.getMovieName());

        MovieFactoryInterface bollyWoodMovieFactory = FactoryProducer.getFactory(FactoryProducer.Type.BOLLYWOOD);

        BollyWoodMovieInterface bAction = bollyWoodMovieFactory.getBollyWoodMovie(MovieType.ACTION);
        BollyWoodMovieInterface bComedy = bollyWoodMovieFactory.getBollyWoodMovie(MovieType.COMEDY);

        System.out.println("\nBollyWood movies  are:");
        System.out.println(bAction.getMovieName());
        System.out.println(bComedy.getMovieName());
    }
}