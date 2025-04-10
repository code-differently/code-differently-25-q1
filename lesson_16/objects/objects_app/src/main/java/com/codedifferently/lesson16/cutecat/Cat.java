package com.codedifferently.lesson16.cutecat;

import java.util.ArrayList;
import java.util.Arrays;

// Exception
class InvalidCatNameException extends Exception {
  public InvalidCatNameException(String message) {
    super(message);
  }
}

// Enum for Cat Breed
enum Breed {
  SIAMESE,
  PERSIAN,
  MAINCOON,
  SPHYNX,
  BENGAL,
  UNKNOWN
}

public class Cat {
  // Member variables
  private String name;
  private int age;
  private double weight;
  private boolean isIndoor;
  private Breed breed;
  private ArrayList<String> favoriteFoods;

  // Constructor
  public Cat(String name, int age, double weight, Breed breed, boolean isIndoor)
      throws InvalidCatNameException {
    if (name == null || name.trim().isEmpty()) {
      throw new InvalidCatNameException("Cat name cannot be empty.");
    }
    this.name = name;
    this.age = age;
    this.weight = weight;
    this.isIndoor = isIndoor;
    this.breed = breed;
    this.favoriteFoods =
        new ArrayList<>(Arrays.asList("Fancy Feast", "Purina Naturals")); // Default for Ninja
  }

  // Function 1: Add Favorite Food (uses collection)
  public void addfavoriteFood(String food) {
    favoriteFoods.add(food);
  }

  // Function 2: Print Favorite Foods (uses loop)
  public void printfavoriteFoods() {
    System.out.println(name + "'s favorite foods:");
    for (String v : favoriteFoods) {
      System.out.println("- " + v);
    }
  }

  // Function 3: Is the cat a senior? (uses conditional)
  public boolean isSenior() {
    return age >= 10;
  }

  // Getters for testing
  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public double getWeight() {
    return weight;
  }

  public boolean getIsIndoor() {
    return isIndoor;
  }

  public Breed getBreed() {
    return breed;
  }

  public ArrayList<String> getfavoriteFoods() {
    return favoriteFoods;
  }
}
