package com.codedifferently.lesson16.hiphopArtist;

import java.util.ArrayList;

public class HipHopArtist {
  private boolean isAlive;
  private String stageName;
  private int debutYear;
  private double netWorth;
  private ArrayList<String> albums;
  private Genre genre;

  public HipHopArtist(
      boolean isAlive,
      String stageName,
      int debutYear,
      double netWorth,
      ArrayList<String> albums,
      Genre genre) {
    this.isAlive = isAlive;
    this.stageName = stageName;
    this.debutYear = debutYear;
    this.netWorth = netWorth;
    this.albums = albums;
    this.genre = genre;
  }

  public String checkLegendStatus() {
    return debutYear <= 2000
        ? stageName + " is a legend in the game."
        : stageName + " is a modern star.";
  }

  public void addAlbum(String album) {
    albums.add(album);
    System.out.println(album + " was added to " + stageName + "'s discography.");
  }

  public String listAlbums() throws NoAlbumsException {
    if (albums.isEmpty()) {
      throw new NoAlbumsException(stageName + " has no albums listed.");
    }
    System.out.println("Albums by " + stageName + ":");
    for (String album : albums) {
      System.out.println("- " + album);
    }
    return stageName;
  }

  public String getBio() {
    return stageName
        + " ("
        + genre
        + ") debuted in "
        + debutYear
        + ", is "
        + (isAlive ? "alive" : "deceased")
        + ", and has a net worth of $"
        + netWorth
        + ".";
  }

  public boolean isAlive() {
    return isAlive;
  }

  public void setAlive(boolean alive) {
    isAlive = alive;
  }

  public String getStageName() {
    return stageName;
  }

  public void setStageName(String stageName) {
    this.stageName = stageName;
  }

  public int getDebutYear() {
    return debutYear;
  }

  public void setDebutYear(int debutYear) {
    this.debutYear = debutYear;
  }

  public double getNetWorth() {
    return netWorth;
  }

  public void setNetWorth(double netWorth) {
    this.netWorth = netWorth;
  }

  public ArrayList<String> getAlbums() {
    return albums;
  }

  public void setAlbums(ArrayList<String> albums) {
    this.albums = albums;
  }

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  public enum Genre {
    RAP,
    GANGSTA_RAP,
    OLD_SCHOOL,
    TRAP,
    DRILL,
  }

  @Override
  public String toString() {
    return "HipHopArtist{"
        + "isAlive="
        + isAlive
        + ", stageName='"
        + stageName
        + '\''
        + ", debutYear="
        + debutYear
        + ", netWorth="
        + netWorth
        + ", albums="
        + albums
        + ", genre="
        + genre
        + '}';
  }
}

class NoAlbumsException extends Exception {
  public NoAlbumsException(String message) {
    super(message);
  }
}
