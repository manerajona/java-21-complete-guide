package com.manerajona.java.designpatterns.behavioral.strategy.example4;

import org.apache.commons.lang3.tuple.Pair;

class QuadraticEquationSolver {
    private final DiscriminantStrategy strategy;

    public QuadraticEquationSolver(DiscriminantStrategy strategy) {
        this.strategy = strategy;
    }

    public Pair<Complex, Complex> solve(double a, double b, double c) {
        double disc = strategy.calculateDiscriminant(a, b, c);
        Complex rootDisc = Complex.sqrt(disc);
        return Pair.of(
                new Complex(-b, 0).plus(rootDisc)
                        .divides(new Complex(2, 0))
                        .divides(new Complex(a, 0)),
                new Complex(-b, 0).minus(rootDisc)
                        .divides(new Complex(2, 0))
                        .divides(new Complex(a, 0))
        );
    }
}
