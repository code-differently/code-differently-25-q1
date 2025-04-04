package com.codedifferently.lesson13;

import java.util.HashMap;

public class Lesson13 {

  /**
   * Provide the solution to LeetCode 3146 here:
   * https://leetcode.com/problems/permutation-difference-between-two-strings
   */
  public int findPermutationDifference(String s, String t) {
    // initializing the permuation difference between the characters 
    int difference = 0;

    // creating a hashmap to store the index of each character in s - the key value pair
    // the key is the character and the value is the index
    HashMap<Character, Integer> characterPosition = new HashMap<>();

    // iterates through character in s with i as index
    for (int i = 0; i < s.length(); i++) {
      // returns the map of character at a given index 
      characterPosition.put(s.charAt(i), i);
    }
    
    // calcualting permutation difference
    for (int i = 0; i < t.length(); i++) {
      //using a built in function - math.abs to calculate the difference in character index
      // index of character in string s - index of character in string i
        difference += Math.abs(i - characterPosition.get(t.charAt(i)));
    }
    return difference;
  }
}
