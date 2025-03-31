package com.codedifferently.lesson11;

import java.util.ArrayList;
import java.util.List;

public class Lesson11 {

  /**
   * Provide the solution to LeetCode 1929 here:
   * https://leetcode.com/problems/concatenation-of-array
   */
  public int[] getConcatenation(int[] nums) {
    int n = nums.length;
    int[] result = new int[n * 2];

    for (int i = 0; i < n; i++) {
      result[i] = nums[i];
      result[i + n] = nums[i];
    }
    return result;
  }

  /**
   * Provide the solution to LeetCode 2942 here:
   * https://leetcode.com/problems/find-words-containing-character/
   */
  public List<Integer> findWordsContaining(String[] words, char x) {
    List<Integer> check = new ArrayList<>();

    for (int i = 0; i < words.length; i++) {
      if (words[i].contains(String.valueOf(x))) {
        check.add(i);
      }
    }

    return check;
  }
}
