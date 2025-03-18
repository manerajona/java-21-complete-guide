package com.manerajona.java.designpatterns.behavioral.strategy.example4;

interface DiscriminantStrategy {
    double calculateDiscriminant(double a, double b, double c);
}

class OrdinaryDiscriminantStrategy implements DiscriminantStrategy {
    @Override
    public double calculateDiscriminant(double a, double b, double c) {
        return (b * b) - (4 * a * c);
    }
}

class RealDiscriminantStrategy implements DiscriminantStrategy {
    @Override
    public double calculateDiscriminant(double a, double b, double c) {
        double result = (b * b) - (4 * a * c);
        return (result >= 0) ? result : Double.NaN;
    }
}