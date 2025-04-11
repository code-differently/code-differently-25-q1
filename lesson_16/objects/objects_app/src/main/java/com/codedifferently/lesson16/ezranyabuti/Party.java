package com.codedifferently.lesson16.ezranyabuti;

import java.util.ArrayList;

public class Party {

  private String name;
  private String location;
  private String LocalDate;
  private Boolean isPrivate;
  private double coverCharge;
  private int ticketNumber;
  private Vibe vibe;
  private ArrayList<String> guestList;

  public void partyClass(
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

  

  public Boolean getIsPrivate() {
    return isPrivate;
  }

  public void setIsPrivate(Boolean isPrivate) {
    this.isPrivate = isPrivate;
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

  public void addGuest(String guest) throws partyException {
    if (guestList.size() < ticketNumber) {
      guestList.add(guest);
    } else {
      throw new partyException("Party is full");
    }
  }
}
