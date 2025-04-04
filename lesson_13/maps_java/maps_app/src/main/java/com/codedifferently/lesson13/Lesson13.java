package com.codedifferently.lesson13;

public class Lesson13 {

  /**
   * Provide the solution to LeetCode 3146 here:
   * https://leetcode.com/problems/permutation-difference-between-two-strings
   */
  public int findPermutationDifference(String s, String t) {
    int answer = 0;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      int index = t.indexOf(ch);

      answer += Math.abs(index - i);
    }
    return answer;
  }
}
