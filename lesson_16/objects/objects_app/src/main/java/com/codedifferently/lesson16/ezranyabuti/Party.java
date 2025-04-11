package com.codedifferently.lesson16.ezranyabuti;

import java.util.ArrayList;

public class Party {

  private String name;
  private String location;
  private String localDate;
  private Boolean isPrivate;
  private double coverCharge;
  private int ticketNumber;
  private Vibe vibe;
  private ArrayList<String> guestList;

  public Party(
      String name,
      String location,
      String localDate,
      Boolean isPrivate,
      Double coverCharge,
      int ticketNumber,
      Vibe vibe,
      String[] guestList) {
    this.name = name;
    this.location = location;
    this.isPrivate = isPrivate;
    this.coverCharge = coverCharge;
    this.ticketNumber = ticketNumber;
    this.vibe = vibe;
    this.guestList = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getLocalDate() {
    return localDate;
  }

  public void setLocalDate(String localDate) {
    this.localDate = localDate;
  }

  public Boolean getIsPrivate() {
    return isPrivate;
  }

  public void setIsPrivate(Boolean isPrivate) {
    this.isPrivate = isPrivate;
  }

  public double getCoverCharge() {
    return coverCharge;
  }

  public void setCoverCharge(double coverCharge) {
    this.coverCharge = coverCharge;
  }

  public int getTicketNumber() {
    return ticketNumber;
  }

  public void setTicketNumber(int ticketNumber) {
    this.ticketNumber = ticketNumber;
  }

  public Vibe getVibe() {
    return vibe;
  }

  public void setVibe(Vibe vibe) {
    this.vibe = vibe;
  }

  public ArrayList<String> getGuestList() {
    ArrayList<String> copy = new ArrayList<>();
    for (String guest : guestList) {
      copy.add(guest);
    }
    return copy;
  }

  public void setGuestList(ArrayList<String> guestList) {
    this.guestList = guestList;
  }
}
