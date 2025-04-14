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
 
    // Core methods  
    
    // Method adds item to closet
   public boolean addItem(ClothingItem item) {
         // If closet is full, cannot add item
        if (items.size() >= maxCapacity) {
            return false;
        }
    
        // Adding item to closet and increasing total value of closet
        items.add(item);
        totalValue += item.getValue();

        // Checks what season item is meant for and keeps track of number of items in that season 
        Season season = item.getSeason();
        seasonalItems.put(season, seasonalItems.getOrDefault(season, 0) + 1);
    
        // Returns true if item is added
        return true;
   }

   // Method removes item from closet
   public void removeItem(ClothingItem item) throws ItemNotFoundException {
        // If item is not in closet, throws an error
        if (!items.contains(item)) {
            throw new ItemNotFoundException("Item is not in closet.");
        }

         // Remove item from closet and decreases toal value of closet
        items.remove(item);
        totalValue -= item.getValue();

        // Grab clothing item based on season and decrease count
        Season season = item.getSeason();
        seasonalItems.put(season, seasonalItems.get(season) - 1);
   }


   // Method creates outfit by selecting items based on the season
   public List<ClothingItem> createOutfit(Season season) {
        // Creating empty list that stores clothing items
        List<ClothingItem> outfit = new ArrayList<>();

        // Iterating through all items in the closet and grabbing item at index 
        for (int i = 0; i < items.size(); i++) {
            ClothingItem item = items.get(i);

            // Check if clothing item matches particular season or is good for all seasons
            if (item.getSeason() == season || item.getSeason() == Season.ALL_SEASON) {
                //add item to list
                outfit.add(item);
            }
        }
        // Returns final list of clothing items in an outfit
        return outfit;
   }

   // Method organizes closet by type of item and color
   public void organizeCloset() {
        // Create a map where key is type of clothing and value is list of clothing items of that type
        Map<String, List<ClothingItem>> organized = new HashMap<>();


        // Iterate through every item in closet
        for (int i = 0; i < items.size(); i++) {
            ClothingItem item = items.get(i);
            String type = item.getType();

            // Check if that type of clothing item is in the list
            List<ClothingItem> itemList = organized.get(type);
            if (itemList == null) {
                // If it doesn’t exist, make a new list and put it in the map
                itemList = new ArrayList<>();
                organized.put(type, itemList);
            }

            // Adding items to list by type
            itemList.add(item);
        }

        // closet is organized 
        isOrganized = true;
   }

   // method returns a map shwoing how many items are in closet based on season 
   public Map<Season, Double> getSeasonalItem() {
        return new HashMap<>(seasonalItems);
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

   public void setMaxCapacity() {
        this.maxCapacity = maxCapacity;
   }

   public double getTotalValue() {
        return totalValue;
   }

   public void setTotalValue() {
        this.totalValue = totalValue;
   }

   public boolean isOrganized () {
    return isOrganized;
   }

   public void set

   public List<ClothingItem> getItems() {
        return new ArrayList<>(items);      
   }

   // Custom exception if item is not found in closet
    public static class ItemNotFoundException extends Exception{
        public ItemNotFoundException(String message) {
            super(message);
        }
    }
}

