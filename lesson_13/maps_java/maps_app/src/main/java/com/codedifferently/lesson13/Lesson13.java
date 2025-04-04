package com.codedifferently.lesson13;

import java.util.HashMap;

public class Lesson13 {

  /**
   * Provide the solution to LeetCode 3146 here:
   * https://leetcode.com/problems/permutation-difference-between-two-strings
   */
  public int findPermutationDifference(String s, String t) {
    var sIndexByLetter = new HashMap<Character, Integer>();
    var tIndexByLetter = new HashMap<Character, Integer>();

    for (int i = 0; i < s.length(); i++) {
      sIndexByLetter.put(s.charAt(i), i);
      tIndexByLetter.put(t.charAt(i), i);
    }

    int sum = 0;
    for (char c : s.toCharArray()) {
      sum += Math.abs(sIndexByLetter.get(c) - tIndexByLetter.get(c));
    }

    return sum;
  }
}
