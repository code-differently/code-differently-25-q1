package com.codedifferently.lesson16.strengthmachine;

import java.util.ArrayList;

public class StrengthMachine {
  private String name;
  private int currentWeight;
  private boolean inUse;
  private ArrayList<String> safetyTips;
  private MuscleGroup targetMuscle;

  public enum MuscleGroup {
    SHOULDERS,
    CHEST,
    ARMS,
    LEGS,
    BACK
  }

  public StrengthMachine(
      String name,
      int currentWeight,
      boolean inUse,
      ArrayList<String> safetyTips,
      MuscleGroup targetMuscle) {
    this.name = name;
    this.currentWeight = currentWeight;
    this.inUse = inUse;
    this.safetyTips = safetyTips;
    this.targetMuscle = targetMuscle;
  }

  public StrengthMachine(String name, MuscleGroup targetMuscle) {
    this.name = name;
    this.currentWeight = 5;
    this.inUse = false;
    this.safetyTips = new ArrayList<>();
    this.targetMuscle = targetMuscle;
  }

  public boolean isAvailable() {
    return !inUse;
  }

  public void increaseWeightGradually(int targetWeight) {
    while (currentWeight < targetWeight) {
      currentWeight += 5;
    }
  }

  public void addSafetyTip(String tip) {
    safetyTips.add(tip);
  }

  public void useMachine() {
    if (isAvailable()) {
      inUse = true;
    } else {
      throw new MachineInUseException("Cannot use - Machine currently in use");
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCurrentWeight() {
    return currentWeight;
  }

  public void setCurrentWeight(int currentWeight) {
    this.currentWeight = currentWeight;
  }

  public boolean getInUse() {
    return inUse;
  }

  public void setInUse(boolean inUse) {
    this.inUse = inUse;
  }

  public ArrayList<String> getSafetyTips() {
    return safetyTips;
  }

  public void setSafetyTips(ArrayList<String> safetyTips) {
    this.safetyTips = safetyTips;
  }

  public MuscleGroup getTargetMuscle() {
    return targetMuscle;
  }

  public void setTargetMuscle(MuscleGroup targetMuscle) {
    this.targetMuscle = targetMuscle;
  }
}
