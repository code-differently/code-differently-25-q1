package com.codedifferently.lesson11;

import java.util.ArrayList;
import java.util.List;

public class Lesson11 {

  /**
   * Provide the solution to LeetCode 1929 here:
   * https://leetcode.com/problems/concatenation-of-array
   */
  public int[] getConcatenation(int[] nums) {

    int[] result = new int[nums.length * 2]; // Create a new array with double the size of nums
    for (int i = 0; i < nums.length; i++) {
      result[i] = nums[i]; // First half of result array gets the elements from nums
      result[i + nums.length] =
          nums[i]; // Second half of result array gets the same elements from nums
    }
    return result;
  }

  /**
   * Provide the solution to LeetCode 2942 here:
   * https://leetcode.com/problems/find-words-containing-character/
   */
  public List<Integer> findWordsContaining(String[] words, char x) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      if (words[i].indexOf(x) >= 0) { // Check if character 'x' is present in the word
        result.add(i); // Add the index of the word to the result
      }
    }
    return result;
  }
}
