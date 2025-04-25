package com.codedifferently.lesson16.player;

public class Player {

  private String name;
  private Type type;
  private int level;
  private double currentExperience;
  private int expPerFight;
  private boolean isAlive;

  public enum Type {
    HUMAN,
    ELF,
    ORC,
    DRAGONIOD
  }

  public Player(
      String name,
      Type type,
      int level,
      double currentExperience,
      int expPerFight,
      boolean isAlive) {
    this.name = name;
    this.type = type;
    this.level = level;
    this.currentExperience = currentExperience;
    this.expPerFight = expPerFight;
    this.isAlive = isAlive;
  }

  // Getters and Setters
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type characterType) {
    this.type = characterType;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public double getCurrentExperience() {
    return currentExperience;
  }

  public void setCurrentExperiience(double currentExperience) {
    this.currentExperience = currentExperience;
  }

  public int getExpPerFight() {
    if (expPerFight <= 0) {
      throw new IllegalStateException("Experience per fight must be greater than 0.");
    }
    return expPerFight;
  }

  public void setExpPerFight(int expPerFight) {
    this.expPerFight = expPerFight;
  }

  public boolean getIsAlive() {
    return isAlive;
  }

  public void gainExperience(int fights) {
    for (int i = 0; i < fights; i++) {
      currentExperience += expPerFight;

      double requiredExp = 100 * Math.pow(2, level - 1); // Level 1: 100 XP, Level 2: 200 XP, etc.

      while (currentExperience >= requiredExp) {
        currentExperience -= requiredExp; // carry over any extra XP
        level++;
        System.out.println(name + " leveled up to level " + level + "!");
        requiredExp = 100 * Math.pow(2, level - 1); // Update the required XP for the new level
      }
    }
    // used ai for lines between 85 and 97
  }
}

  // int level = 1; int experience = 0; for(int i = 1; i <= 100; i++) {
