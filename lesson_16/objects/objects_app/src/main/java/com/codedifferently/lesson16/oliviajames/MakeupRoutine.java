package com.codedifferently.lesson16.oliviajames;

import java.util.ArrayList;
import java.util.List;

public class MakeupRoutine {

  public enum MakeupLook {
    DEWY,
    NATURAL,
    FULL_GLAM,
    SOFT_GLAM,
  }

  // Member Variables
  private String name;
  private int time;
  private final boolean usesPrimer;
  private final MakeupLook lookType;
  List<String> vanityItems;

  // Constructor
  public MakeupRoutine(String name, int time, boolean usesPrimer, MakeupLook lookType) {
    this.name = name;
    this.time = time;
    this.usesPrimer = true;
    this.lookType = lookType;
  }

  // Getters/setters

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
  }

  public boolean getUsesPrimer() throws MissingPrimerException {
    if (!usesPrimer) {
      throw new MissingPrimerException("missing primer");
    }
    System.out.println("has primer");
    return true;
  }

  public MakeupLook getLookType() {
    return lookType;
  }

  public void MakeupVanity() {
    vanityItems = new ArrayList<>();
    vanityItems.add("Foundation");
    vanityItems.add("Concealer");
    vanityItems.add("Setting Powder");
    vanityItems.add("Blush");
    vanityItems.add("Highlighter");
    vanityItems.add("Eyeshadow Palette");
    vanityItems.add("Mascara");
    vanityItems.add("Eyeliner");
    vanityItems.add("Lipstick");
    vanityItems.add("Lip Gloss");
    vanityItems.add("Setting Spray");
    vanityItems.add("Makeup Brushes");
  }

  public void showVanityItems() {
    System.out.println("Items on the vanity:");
    for (String item : vanityItems) {
      System.out.println("- " + item);
    }
  }
}
