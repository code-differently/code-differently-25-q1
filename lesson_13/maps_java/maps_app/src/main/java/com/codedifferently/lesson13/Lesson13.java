package com.codedifferently.lesson13;

public class Lesson13 {

  /**
   * Provide the solution to LeetCode 3146 here:
   * https://leetcode.com/problems/permutation-difference-between-two-strings
   */
  public int findPermutationDifference(String s, String t) {
    int total = 0;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      int idx2 = t.indexOf(ch);

      total += Math.abs(i - idx2);
    }
    return total;
  }
}
