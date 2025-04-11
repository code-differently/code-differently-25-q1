package com.codedifferently.lesson16.personcomputer;

import java.util.ArrayList;
import java.util.List;

public class Computer {
  public enum ComputerStatus {
    OFFLINE,
    ONLINE,
    SLEEP,
    SHUTDOWN
  }

  private String brand;
  private String model;
  private String cpu;
  private int ramGB;
  private int storageGB;
  private boolean isPoweredOn;
  private List<String> installedPrograms;
  private ComputerStatus status; // use the enum here

  public Computer(
      String brand, String model, String cpu, int ramGB, int storageGB, String installedPrograms) {
    this.brand = brand;
    this.model = model;
    this.cpu = cpu;
    this.ramGB = ramGB;
    this.storageGB = storageGB;
    this.isPoweredOn = false;
    this.installedPrograms = new ArrayList<>();
    this.status = ComputerStatus.OFFLINE;
  }

  public class ComputerAlreadyOnException extends Exception {
    public ComputerAlreadyOnException(String message) {
      super(message);
    }
  }

  public void powerOn() throws ComputerAlreadyOnException {
    if (!isPoweredOn) {
      isPoweredOn = true;
      status = ComputerStatus.ONLINE;
    } else {
      throw new ComputerAlreadyOnException("Computer is already powered on.");
    }
  }

  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public String getCPU() {
    return cpu;
  }

  public int getRAMGB() {
    return ramGB;
  }

  public int getSTORAGEGB() {
    return storageGB;
  }

  public boolean isPoweredOn() {
    return isPoweredOn;
  }

  public ComputerStatus getStatus() {
    return status;
  }

  public void listPrograms() {
    System.out.println("Installed Programs:");
    for (String program : installedPrograms) {
      System.out.println("- " + program);
    }
  }

  public void installProgram(String programName) {
    if (!installedPrograms.contains(programName)) {
      installedPrograms.add(programName);
    }
  }

  public List<String> getInstalledPrograms() {
    return installedPrograms;
  }
}
