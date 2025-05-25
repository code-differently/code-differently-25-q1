package com.codedifferently.lesson16.davidadenaike;

import java.util.ArrayList;
import java.util.List;

public class Shinobi {
  private String name;
  private Village village;
  private String rank;
  private int ryo;
  private char missionRank;
  private List<String> jutsus;

  public Shinobi(String name, Village village, String rank) throws RogueShinobiException {
    if ("rogue".equalsIgnoreCase(rank)) {
      throw new RogueShinobiException("You are a shame to all Shinobis!");
    }

    this.name = name;
    this.village = village;
    this.rank = rank;
    this.ryo = 0;
    this.missionRank = 'D';
    this.jutsus = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public Village getVillage() {
    return village;
  }

  public String getRank() {
    return rank;
  }

  public int getRyo() {
    return ryo;
  }

  public void addRyo(int amount) {
    this.ryo += amount;
  }

  public char getMissionRank() {
    return missionRank;
  }

  public void setMissionRank(char missionRank) {
    this.missionRank = missionRank;
  }

  public void setRank(String rank) throws RogueShinobiException {
    if ("rogue".equalsIgnoreCase(rank)) {
      throw new RogueShinobiException("Cannot set rank to rogue!");
    }
    this.rank = rank;
  }

  public String determineRank() {
    if (jutsus.size() >= 10 && missionRank == 'S') {
      return "Jōnin";
    } else if (jutsus.size() >= 5 && (missionRank == 'A' || missionRank == 'B')) {
      return "Chūnin";
    } else {
      return "Genin";
    }
  }

  public List<String> getJutsus() {
    return new ArrayList<>(jutsus);
  }

  public void addJutsu(String jutsu) {
    jutsus.add(jutsu);
  }

  public boolean checkForPromotion() {
    String[] rankProgression = {"Genin", "Chūnin", "Jōnin"};
    String currentDeterminedRank = determineRank();

    for (int i = 0; i < rankProgression.length; i++) {
      if (rank.equals(rankProgression[i])) {
        // Check if there's a next rank and if the determined rank is higher
        if (i < rankProgression.length - 1
            && currentDeterminedRank.equals(rankProgression[i + 1])) {
          return true;
        }
        break;
      }
    }
    return false;
  }
}
