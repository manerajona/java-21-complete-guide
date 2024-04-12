package com.manerajona.java.programming.oop.localclasses;

public class AnonymousClass {
    private static Button btnPrint = new Button("Print");
    private static Button btnCopy = new Button("Copy");
    private static Button btnPaste = new Button("Paste");

    public static void main(String[] args) {

        // Local Class
        class ClickListener implements Button.OnClickListener {
            public ClickListener() {
                System.out.println("Only me is allowed to define a constructor");
            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked!");
            }
        }
        btnPrint.setOnClickListener(new ClickListener());
        btnPrint.onClick();

        // Anonymous class
        btnCopy.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked!");
            }
        });
        btnCopy.onClick();

        // Anonymous class with lambda
        btnPaste.setOnClickListener(title -> System.out.println(title + " was clicked!"));
        btnPaste.onClick();
    }

}
