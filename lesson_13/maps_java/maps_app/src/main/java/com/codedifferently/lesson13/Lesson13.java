package com.codedifferently.lesson13;

import java.util.HashMap;

public class Lesson13 {

  /**
   * Provide the solution to LeetCode 3146 here:
   * https://leetcode.com/problems/permutation-difference-between-two-strings
   */
  public int findPermutationDifference(String s, String t) {
    int difference = 0;

    var charByIndex = new HashMap<Character, Integer>();

    for (int i = 0; i < s.length(); i++) {
      charByIndex.put(s.charAt(i), i);
    }

    for (int j = 0; j < t.length(); j++) {
      char ch = t.charAt(j);

      if (charByIndex.containsKey(ch)) {

        difference += Math.abs(charByIndex.get(ch) - j);
      } else {

        int indexInS = s.indexOf(ch);
        difference += Math.abs(indexInS - j);
      }
    }

    return difference;
  }
}
