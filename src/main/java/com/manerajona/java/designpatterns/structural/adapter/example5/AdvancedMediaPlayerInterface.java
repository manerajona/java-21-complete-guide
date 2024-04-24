package com.manerajona.java.designpatterns.structural.adapter.example5;

// Adaptee
interface AdvancedMediaPlayerInterface {
    void loadFilename(String fileName);

    void listen();
}

class VlcPlayer implements AdvancedMediaPlayerInterface {

    private String myFile;

    @Override
    public void loadFilename(String filename) {
        myFile = filename;
    }

    @Override
    public void listen() {
        System.out.println("Playing vlc file.  Name: " + myFile);
    }
}

class Mp4Player implements AdvancedMediaPlayerInterface {

    private String myFile;

    @Override
    public void loadFilename(String filename) {
        myFile = filename;
    }

    @Override
    public void listen() {
        System.out.println("Playing mp4 file.  Name: " + myFile);
    }
}