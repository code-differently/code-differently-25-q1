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
   private ArrayList<ClothingItem> items;
   private HashMap<Season, Integer> seasonalItems;

    // Constructor for personal closet
   public PersonalCloset (String ownerName, int maxCapacity) {
        this.ownerName = ownerName;
        this.maxCapacity = maxCapacity;
        this.totalValue = 0.0;
        this.isOrganized = false;
        this.items = new ArrayList<>();
        this.seasonalItems = new HashMap<>();
   }
 
    //core methods  
    
    // adds item to closet
   public boolean addItem(ClothingItem item) {
    // if closet is full, cannot add item
    if (items.size(0) >= maxCapacity) {
            return false;
        }
    
    //adding item to closet and increasing closet total value of closet
    items.add(item);
    totalValue += item.getValue();

    // checks what season item is meant for and keeps track of number of items in that season 
    Season seaason = item.getSeason();
    seasonalItems.put(season, seasonalItems.getOrDefault(season, 0) + 1);
    
    // returns true if item is added
    return true;
   }

   // removes item from closet
   public void removeItem(ClothingItem item) {
        return;
   }

   // throws exception if item is not found in closet
    public static class ItemNotFoundException extends Exception{
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

   public void setOwnerName(String ownerName) {
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

