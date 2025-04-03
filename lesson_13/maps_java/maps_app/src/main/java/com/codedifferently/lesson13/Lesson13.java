package com.codedifferently.lesson13;

import java.util.HashMap;

public class Lesson13 {

  /**
   * Provide the solution to LeetCode 3146 here:
   * https://leetcode.com/problems/permutation-difference-between-two-strings
   */
  public int findPermutationDifference(String s, String t) {
    var charByIndex = new HashMap<Character, Integer>();

    // Stores each character index from s into an Array
    for (int i = 0; i < s.length(); ++i) {
      charByIndex.put(s.charAt(i), i);
    }

    // will be the difference between s and t's index's
    int difference = 0;

    for (int j = 0; j < t.length(); ++j) {
      if (charByIndex.containsKey(t.charAt(j))) {
        // Math.abs gets the absole number ensuring the difference is always positive
        // My logic here is that it will find the index of t and subtract that from j which is that
        // original index of that char
        difference += Math.abs(charByIndex.get(t.charAt(j)) - j);
      }
    }
    // Runs a for loop that will be the length of t but this time we will be using the map t
    // tell our loop to run until it finds the same character
    return difference;
  }
}
