package com.codedifferently.lesson11;

import java.util.ArrayList;
import java.util.List;

public class Lesson11 {

  /**
   * Solution to LeetCode problem: Concatenation of Array
   * https://leetcode.com/problems/concatenation-of-array
   */
  public int[] getConcatenation(int[] nums) {
    int size = nums.length;

    int[] result = new int[size * 2];

    for (int i = 0; i < size * 2; i++) {
      result[i] = nums[i % size];
    }

    return result;
  }

  /**
   * Solution to LeetCode problem: Find Words Containing Character
   * https://leetcode.com/problems/find-words-containing-character/
   */
  public List<Integer> findWordsContaining(String[] words, char x) {
    List<Integer> result = new ArrayList<>();

    String searchChar = String.valueOf(x);

    for (int i = 0; i < words.length; i++) {
      if (words[i].contains(searchChar)) {
        result.add(i);
      }
    }

    return result;
  }
}
