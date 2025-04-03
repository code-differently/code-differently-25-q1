package com.codedifferently.lesson13;

import java.util.HashMap;
import java.util.Map;

public class Lesson13 {

  /**
   * Provide the solution to LeetCode 3146 here:
   * https://leetcode.com/problems/permutation-difference-between-two-strings
   */
  public int findPermutationDifference(String s, String t) {
    Map<Character, Integer> smap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      smap.put(c, i);
    }
    Map<Character, Integer> tmap = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      tmap.put(c, i);
    }
    int ans = 0;
    for (char c : smap.keySet()) {
      ans = ans + Math.abs(smap.get(c) - tmap.get(c));
    }
    return ans;
  }
}
