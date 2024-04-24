package com.manerajona.java.designpatterns.structural.adapter.example5;

public class Main {
    public static void main(String[] args) {
        MediaPlayerInterface audioPlayer = new AudioPlayer();
        playMusic(audioPlayer);

        AdvancedMediaPlayerInterface mp4Player = new Mp4Player();
        MediaPlayerInterface mp4PlayerToAudioPlayer = new AdvancedMediaPlayerAdapter(mp4Player);
        playMusic(mp4PlayerToAudioPlayer);

        AdvancedMediaPlayerInterface vlcPlayer = new VlcPlayer();
        MediaPlayerInterface vlcPlayerToAudioPlayer = new AdvancedMediaPlayerAdapter(vlcPlayer);
        playMusic(vlcPlayerToAudioPlayer);
    }

    static void playMusic(MediaPlayerInterface audioPlayer) {
        System.out.println("\nPlaying music for " + audioPlayer.getClass());
        audioPlayer.play("jasonsMusic.mp3");
        audioPlayer.play("jasonsMusic.mp4");
    }
}
