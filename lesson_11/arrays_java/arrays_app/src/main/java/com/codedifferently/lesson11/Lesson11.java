package com.codedifferently.lesson11;

import java.util.ArrayList;
import java.util.List;

public class Lesson11 {

  public int[] getConcatenation(int[] nums) {
    int n = nums.length;
    int[] results = new int[2 * n];
    for (int i = 0; i < n; i++) {
      results[i] = nums[i];
      results[i + n] = nums[i];
    }
    return results;
  }

  // lookiing for an integer array that has a concatenation method Im going to given the paramters
  // of integer array of variable named nums
  // We are declaring one of the variable which is n which equals num.length.

  /**
   * Provide the solution to LeetCode 2942 here:
   * https://leetcode.com/problems/find-words-containing-character/
   */
  public List<Integer> findWordsContaining(String[] words, char x) {
    List<Integer> indices = new ArrayList<>();
    // The new array lists is the result of the place of the indices
    for (int i = 0; i < words.length; i++) {
      if (words[i].indexOf(x) != -1) {
        indices.add(i);
      }
    }
    return indices;
  }
}
