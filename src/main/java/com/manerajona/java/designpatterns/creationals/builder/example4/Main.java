package com.manerajona.java.designpatterns.creationals.builder.example4;

public class Main {
    public static void main(String[] args) {
        PersonaBuilder pb = new PersonaBuilder();
        Persona person = pb
                .name("Jonathan")
                .lives()
                .at("123 London Road")
                .in("London")
                .withPostcode("SW12BC")
                .works()
                .at("Fabrikam")
                .asA("Engineer")
                .earning(123000)
                .build();

        System.out.println(person);
    }
}
