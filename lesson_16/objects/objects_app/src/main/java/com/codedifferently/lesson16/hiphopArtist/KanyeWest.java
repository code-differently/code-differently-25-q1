package com.codedifferently.lesson16.hiphopArtist;

import java.util.ArrayList;

public class KanyeWest {

  public static void main(String[] args) {
    ArrayList<String> kanyeAlbums = new ArrayList<>();
    kanyeAlbums.add("The College Dropout");
    kanyeAlbums.add("Late Registration");
    kanyeAlbums.add("Graduation");
    kanyeAlbums.add("My Beautiful Dark Twisted Fantasy");
    kanyeAlbums.add("Yeezus");

    var kanye =
        new HipHopArtist(true, "Kanye West", 2004, 400000000, kanyeAlbums, HipHopArtist.Genre.RAP);

    System.out.println(kanye.getBio());
    System.out.println(kanye.checkLegendStatus());

    kanye.addAlbum("Donda");

    try {
      kanye.listAlbums();
    } catch (NoAlbumsException e) {
      System.out.println("ERROR: " + e.getMessage());
    }

    System.out.println(kanye);

    kanye.setNetWorth(500000000);
    System.out.println("Updated net worth: $" + kanye.getNetWorth());
  }
}
