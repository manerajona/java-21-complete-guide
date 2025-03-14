package com.manerajona.java.designprinciples.dependencyinjection.dependencymanager;

public class App {
    public static void main(String[] args) {
        final String packageName = App.class.getPackageName();
        final DependencyManager container = new DependencyManagerImp(packageName);

        var dependency = container.resolve(AppDependency.class);
        dependency.doSomething();
    }
}