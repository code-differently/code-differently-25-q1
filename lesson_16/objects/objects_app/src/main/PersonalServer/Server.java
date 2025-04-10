package com.codedifferently.lesson16.PersonalComputer;

import java.util.ArrayList;
import java.util.List;

public class Server {
  public enum ServerStatus {
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
  private int nic;
  private boolean isPoweredOn;
  private List<String> installedPrograms;
  private ServerStatus status; // use the enum here

  public Server(
      String brand, String model, String cpu, int ramGB, int storageGB, int nic, String installedPrograms) {
    this.brand = brand;
    this.model = model;
    this.cpu = cpu;
    this.ramGB = ramGB;
    this.nic = nic;
    this.storageGB = storageGB;
    this.isPoweredOn = false;
    this.installedPrograms = new ArrayList<>();
    this.status = ServerStatus.OFFLINE;
  }

  public class ComputerAlreadyOnException extends Exception {
    public ComputerAlreadyOnException(String message) {
      super(message);
    }
  }

  public void powerOn() throws ComputerAlreadyOnException {
    if (!isPoweredOn) {
      isPoweredOn = true;
      status = ServerStatus.ONLINE;
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

  public ServerStatus getStatus() {
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
