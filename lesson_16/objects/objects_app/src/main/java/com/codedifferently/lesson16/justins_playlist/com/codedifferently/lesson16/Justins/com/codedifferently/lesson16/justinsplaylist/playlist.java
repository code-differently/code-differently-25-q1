package com.codedifferently.lesson16.justinsplaylist;

import java.util.ArrayList;
import java.util.List;

public class playlist {
    private String name;
    private String genre;
    private int duration;
    private List<String> songs;

    public playlist(String name, String genre, int duration) {
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.songs = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public String getDetails() {
        return "Name: " + name + ", Genre: " + genre + ", Duration: " + duration;
    }

    
        
    
}
