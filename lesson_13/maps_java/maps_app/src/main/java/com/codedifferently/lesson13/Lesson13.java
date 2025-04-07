package com.codedifferently.lesson13;

import java.util.HashMap;

public class Lesson13 {

  /**
   * Provide the solution to LeetCode 3146 here:
   * https://leetcode.com/problems/permutation-difference-between-two-strings
   */
  public int findPermutationDifference(String s, String t) {
    HashMap<Character, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      indexMap.put(s.charAt(i), i);
    }
    int difference = 0;
    for (int i = 0; i < t.length(); i++) {
      if (indexMap.containsKey(t.charAt(i))) {
        difference += Math.abs(indexMap.get(t.charAt(i)) - i);
      }
    }
    return difference;
  }
}
// Used ChatGPT to explain code.
 