package com.manerajona.java.designpatterns.structural.adapter.example5;

class AdvancedMediaPlayerAdapter implements MediaPlayerInterface {

    private final AdvancedMediaPlayerInterface advancedMusicPlayer;

    public AdvancedMediaPlayerAdapter(AdvancedMediaPlayerInterface myMediaPlayer) {
        advancedMusicPlayer = myMediaPlayer;
    }

    @Override
    public void play(String filename) {
        advancedMusicPlayer.loadFilename(filename);
        advancedMusicPlayer.listen();
    }
}
