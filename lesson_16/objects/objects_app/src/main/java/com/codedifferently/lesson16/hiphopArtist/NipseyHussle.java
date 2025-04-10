package com.codedifferently.lesson16.hiphopArtist;

import java.util.ArrayList;

public class NipseyHussle {
  public static void main(String[] args) {
    ArrayList<String> nipseyAlbums = new ArrayList<>();
    nipseyAlbums.add("South Central State of Mind");
    nipseyAlbums.add("The Marathon");
    nipseyAlbums.add("Crenshaw");
    nipseyAlbums.add("Victory Lap");

    for (String album : nipseyAlbums) {
      System.out.println(album);
    }
    var nipsey =
        new HipHopArtist(
            true, "Nipsey Hussle", 2005, 8000000, nipseyAlbums, HipHopArtist.Genre.GANGSTA_RAP);
    System.out.println(nipsey.getBio());
    System.out.println(nipsey.checkLegendStatus());

    nipsey.addAlbum("The Marathon Continues");

    try {
      nipsey.listAlbums();
    } catch (NoAlbumsException e) {
      System.out.println("ERROR: " + e.getMessage());
    }
    System.out.println(nipsey);
    nipsey.setNetWorth(10000000);
    System.out.println("Updated net worth: $" + nipsey.getNetWorth());
  }
}
