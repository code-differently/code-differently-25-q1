package com.codedifferently.lesson11;

import java.util.ArrayList;
import java.util.List;

public class Lesson11 {

  /**
   * Provide the solution to LeetCode 1929 here:
   * https://leetcode.com/problems/concatenation-of-array
   */
  public int[] getConcatenation(int[] nums) {
    // used AI to implement this solution
    if (nums == null || nums.length == 0) {
      return new int[0];
    }
    int originalLength = nums.length;
    int[] result = new int[originalLength * 2];

    for (int i = 0; i < originalLength; i++) {
      result[i] = nums[i];
      result[i + originalLength] = nums[i];
    }
    return result;
  }

  /**
   * Provide the solution to LeetCode 2942 here:
   * https://leetcode.com/problems/find-words-containing-character/
   */
  public List<Integer> findWordsContaining(String[] words, char x) {
    // Montell helped me out with with coding implementation
    // need to create a string array
    List<Integer> search = new ArrayList<>();
    // iterate through elements in string array and compare them with the character
    for (int i = 0; i < words.length; i++) {
      if (words[i].contains(String.valueOf(x))) {
        search.add(i);
      }
    }
    // return the index of the element in the string array that contains the character provided
    return search;
  }
}
