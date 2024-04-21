package com.manerajona.java.designpatterns.creationals.prototype.example4;

import java.io.Serializable;

// some libraries use reflection (no need for Serializable)
class SerializationPrototype implements Serializable {
    private final int stuff;
    private String whatever;

    public SerializationPrototype(int stuff, String whatever) {
        this.stuff = stuff;
        this.whatever = whatever;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "stuff=" + stuff +
                ", whatever='" + whatever + '\'' +
                '}';
    }

    public void setWhatever(String whatever) {
        this.whatever = whatever;
    }
}
