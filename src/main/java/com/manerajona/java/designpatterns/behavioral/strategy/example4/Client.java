package com.manerajona.java.designpatterns.behavioral.strategy.example4;

import org.apache.commons.lang3.tuple.Pair;

public class Client {
    public static void main(String[] args) {
        QuadraticEquationSolver equationSolverOrdinaryDiscriminant = new QuadraticEquationSolver(
                new OrdinaryDiscriminantStrategy()
        );
        Pair<Complex, Complex> ordinaryDiscriminantResult = equationSolverOrdinaryDiscriminant.solve(1., 5., 2.);
        System.out.println("Result=(a=" + ordinaryDiscriminantResult.getLeft() + ", b=" + ordinaryDiscriminantResult.getRight() + ")");

        QuadraticEquationSolver equationSolverRealDiscriminant = new QuadraticEquationSolver(
                new RealDiscriminantStrategy()
        );
        Pair<Complex, Complex> realDiscriminantResult = equationSolverRealDiscriminant.solve(1., 5., 2.);
        System.out.println("Result=(a=" + realDiscriminantResult.getLeft() + ", b=" + realDiscriminantResult.getRight() + ")");
    }
}