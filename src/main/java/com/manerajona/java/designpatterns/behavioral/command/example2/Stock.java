package com.manerajona.java.designpatterns.behavioral.command.example2;

record Stock(String symbol, int quantity) {
    public void buy() {
        System.out.println(this + " - bought");
    }

    public void sell(){
        System.out.println(this +" - sold");
    }
}
