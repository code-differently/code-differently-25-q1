package com.codedifferently.lesson11;

import java.util.ArrayList;
import java.util.List;

public class Lesson11 {

  /**
   * Provide the solution to LeetCode 1929 here:
   * https://leetcode.com/problems/concatenation-of-array
   */
  public int[] getConcatenation(int[] nums) {
    // final int n = nums.length;
    int ans[] = new int[nums.length * 2];
    for (int i = 0; i < nums.length; i++) {
      ans[i] = nums[i];
    }
    int index = nums.length;
    for (int i = 0; i < nums.length; i++) {
      ans[index] = nums[i];
      index++;
    }
    return ans;
  }

  /**
   * Provide the solution to LeetCode 2942 here:
   * https://leetcode.com/problems/find-words-containing-character/
   */
  public List<Integer> findWordsContaining(String[] words, char x) {

    // return null;
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      if (words[i].indexOf(x) != -1) {
        result.add(i);
      }
    }
    return result;
  }
}
