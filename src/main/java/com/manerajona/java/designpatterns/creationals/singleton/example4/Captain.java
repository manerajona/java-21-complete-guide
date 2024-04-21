package com.manerajona.java.designpatterns.creationals.singleton.example4;

class Captain {

    private Captain() {
    }

    // Bill Pugh solution
    private static class Singleton {
        // nested class is referenced after getCaptain() is called
        private static final Captain instance = new Captain();
    }

    public static Captain getInstance() {
        return Singleton.instance;
    }
}