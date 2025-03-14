package com.manerajona.java.designprinciples.dependencyinjection.dependencymanager;

@Dependency
public class AppDependency {
    public void doSomething() {
        System.out.println("dependency call ...");
    }
}