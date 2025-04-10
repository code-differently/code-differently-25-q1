package com.codedifferently.lesson16.hiphopArtist;

import java.util.ArrayList;

public class Eminem {
  public static void main(String[] args) {
    ArrayList<String> EminemAlbums = new ArrayList<>();
    EminemAlbums.add("The Slim Shady LP");
    EminemAlbums.add("The Marshall Mathers LP");
    EminemAlbums.add("The Eminem Show");
    EminemAlbums.add("Encore");
    EminemAlbums.add("Relapse");

    for (String album : EminemAlbums) {
      System.out.println(album);
    }
    var eminem =
        new HipHopArtist(true, "Eminem", 1999, 230000000, EminemAlbums, HipHopArtist.Genre.RAP);
    System.out.println(eminem.getBio());
    System.out.println(eminem.checkLegendStatus());

    eminem.addAlbum("The Marshall Mathers LP 2");

    try {
      eminem.listAlbums();
    } catch (NoAlbumsException e) {
      System.out.println("ERROR: " + e.getMessage());
    }
    System.out.println(eminem);
    eminem.setNetWorth(250000000);
    System.out.println("Updated net worth: $" + eminem.getNetWorth());
  }
}
