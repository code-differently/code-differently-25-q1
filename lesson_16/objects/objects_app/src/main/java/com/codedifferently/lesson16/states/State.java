package com.codedifferently.lesson16.states;

import java.util.ArrayList;

public class State {
  private String name;
  private String capital;
  private int population;
  private double area;
  private Region region;
  private ArrayList<String> majorCities;

  enum Region {
    NORTHEAST,
    MIDWEST,
    SOUTH,
    WEST,
    PACIFIC
  }

  public State(String name, String capital, int population, double area, Region region) {
    this.name = name;
    this.capital = capital;
    this.population = population;
    this.area = area;
    this.region = region;
    this.majorCities = new ArrayList<>();
  }

  public void updatePopulation(int newPopulation) throws PopulationTooLowException {
    if (newPopulation < 10000) {
      throw new PopulationTooLowException("Population too low for a state!");
    }
    this.population = newPopulation;
    System.out.println("Population updated to " + newPopulation);
  }

  public void addMajorCity(String city) {
    majorCities.add(city);
    System.out.println(city = "added to major cities of " + name);
  }

  public void listMajorCities() {
    System.out.println("Major cities in " + name + ":");
    for (String city : majorCities) {
      System.out.println("- " + city);
    }
  }
}
