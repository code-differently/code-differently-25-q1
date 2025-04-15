package com.codedifferently.lesson16.JustinsPylaylist;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private final List<String> songs = new ArrayList<>();

    public void addSong(String song) {
        songs.add(song);
    }

    public void playAll() {
        if (songs.isEmpty()) {
            throw new IllegalStateException("No songs in the playlist to play.");
        }

        System.out.println("Playing all songs in the playlist:");
        for (String song : songs) {
            System.out.println("Playing: " + song);
        }
    }
}
