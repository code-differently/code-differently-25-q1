package com.codedifferently.lesson11;

import java.util.ArrayList;
import java.util.List;

public class Lesson11 {

  /**
   * Provide the solution to LeetCode 1929 here:
   * https://leetcode.com/problems/concatenation-of-array
   */
  public int[] getConcatenation(int[] nums) {

    int answer[] = new int[2 * nums.length];
    for (int i = 0; i < nums.length; i++) {
      answer[i] = nums[i];
      answer[i + nums.length] = nums[i];
    }

    return answer;
  }

  /**
   * Provide the solution to LeetCode 2942 here:
   * https://leetcode.com/problems/find-words-containing-character/
   */
  public List<Integer> findWordsContaining(String[] words, char x) {

    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < words.length; i++) {

      if (words[i].indexOf(x) != -1) {
        result.add(i);
      }
    }

    return result;
  }
}
