package com.codedifferently.lesson16.hiphopArtist;

import java.util.ArrayList;

public class JayZ {

  public static void main(String[] args) {
    ArrayList<String> jayZAlbums = new ArrayList<>();
    jayZAlbums.add("Reasonable Doubt");
    jayZAlbums.add("The Blueprint");
    jayZAlbums.add("The Black Album");
    jayZAlbums.add("4:44");
    jayZAlbums.add("Watch the Throne");

    var jayZ =
        new HipHopArtist(true, "Jay-Z", 1996, 1500000000, jayZAlbums, HipHopArtist.Genre.RAP);

    System.out.println(jayZ.getBio());
    System.out.println(jayZ.checkLegendStatus());

    jayZ.addAlbum("Kingdom Come");

    try {
      jayZ.listAlbums();
    } catch (NoAlbumsException e) {
      System.out.println("ERROR: " + e.getMessage());
    }

    System.out.println(jayZ);

    jayZ.setNetWorth(1600000000);
    System.out.println("Updated net worth: $" + jayZ.getNetWorth());
  }
}
