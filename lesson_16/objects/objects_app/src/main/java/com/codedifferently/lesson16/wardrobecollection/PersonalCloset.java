package com.codedifferently.lesson16.wardobecollection;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

// Personal closet class to represent persons wardrobe collection
public class PersonalCloset {
    // Enum for seaons 
    public enum Season {
        FALL,
        WINTER,
        SPRING,
        SUMMER,
        ALL_SEASON
    }

    // Member variables
   private String ownerName;
   private int maxCapacity;
   private double totalValue;
   private boolean isOrganized;
   private ArrayList<Clothing Item> items;
   private HashMap<Season, Integer> seasonalItems;

    // Constructor for personal closet
   public PersonalCloset (String ownerName, int maxCapacity) {
        this.ownerName = ownerName;
        this.maxCapacity = maxCapacity;
        this.totalValue = 0.0;
        this.isOrganized = false;
        this.items = new ArrayList<>();
        this.seaonalItems = new HashMap<>();
   }
 
    //core methods  
    
    // adds item to closet
   public boolean addItem(ClothingItem item) {
        return false;
   }

   // removes item from closet
   public void removeItem(ClothingItem item) {
        // throws exception if item is not found in closet
        public static class ItemNotFoundException extends Exception{

    }
   }

   // creates outfit by selecting items based on the season
   public List<Clothing Item> createOutfit(Season season) {
    return new ArrayList<>();
   }

   // organizes closet by type of item and color
   public void organizeCloset() {
   }

   // calculates amount of clothing items are in closet based on season 
   public Map<Season, Double> getSeasonalItem() {
        return new HashMap<>();
   }

   // getters and setters
   public String getOwnerName() {
        return ownerName;
   }

   public void setOwnerName() {
        this.ownerName = ownerName;
   }

   public int getMaxCapacity() {
        return maxCapacity;
   }

   public double getTotalValue() {
        return totalValue;
   }

   public boolean isOrganized () {
    return isOrganized;
   }

   public List<ClothingItem> getItems() {
        return new ArrayList<>(items);      
   }

}

