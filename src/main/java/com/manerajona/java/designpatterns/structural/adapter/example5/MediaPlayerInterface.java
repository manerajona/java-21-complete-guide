package com.manerajona.java.designpatterns.structural.adapter.example5;

// Target Interface
interface MediaPlayerInterface {
    void play(String fileName);
}

class AudioPlayer implements MediaPlayerInterface {
    @Override
    public void play(String filename) {
        if (filename.endsWith(".mp3")) {
            System.out.println("Playing mp3 file. Name: " + filename);
        } else {
            System.out.println("Invalid media. " + filename + " format not supported");
        }
    }
}
