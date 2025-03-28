package com.codedifferently.lesson11;

import java.util.ArrayList;
import java.util.List;

public class Lesson11 {

  /**
   * Provide the solution to LeetCode 1929 here:
   * https://leetcode.com/problems/concatenation-of-array
   */
  public int[] getConcatenation(int[] nums) {
    int[] finalArr = new int[nums.length * 2];
    for (int i = 0; i < nums.length; i++) {
      finalArr[i] = nums[i];
      finalArr[i + nums.length] = nums[i];
    }

    return finalArr;
  }

  /**
   * Provide the solution to LeetCode 2942 here:
   * https://leetcode.com/problems/find-words-containing-character/
   */
  public List<Integer> findWordsContaining(String[] words, char x) {
    var results = new ArrayList<Integer>();
    var ch = String.valueOf(x);
    for (int i = 0; i < words.length; i++) {
      if (words[i].contains(ch)) {
        results.add(i);
      }
    }

    return results;
  }
}
