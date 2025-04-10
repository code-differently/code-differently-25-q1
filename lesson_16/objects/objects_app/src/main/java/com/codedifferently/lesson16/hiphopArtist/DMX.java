package com.codedifferently.lesson16.hiphopArtist;

import java.util.ArrayList;

public class DMX {
  public static void main(String[] args) {
    ArrayList<String> dmxAlbums = new ArrayList<>();
    dmxAlbums.add("It's Dark and Hell Is Hot");
    dmxAlbums.add("Flesh of My Flesh, Blood of My Blood");
    dmxAlbums.add("And Then There Was X");
    dmxAlbums.add("The Great Depression");
    dmxAlbums.add("Grand Champ");

    var dmx =
        new HipHopArtist(false, "DMX", 1998, 10000000, dmxAlbums, HipHopArtist.Genre.GANGSTA_RAP);

    System.out.println(dmx.getBio());
    System.out.println(dmx.checkLegendStatus());

    dmx.addAlbum("The Definition of X: Pick of the Litter");

    try {
      dmx.listAlbums();
    } catch (NoAlbumsException e) {
      System.out.println("ERROR: " + e.getMessage());
    }

    System.out.println(dmx);

    dmx.setNetWorth(12000000);
    System.out.println("Updated net worth: $" + dmx.getNetWorth());
  }
}
