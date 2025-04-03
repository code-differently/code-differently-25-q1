package com.codedifferently.lesson13;

public class Lesson13 {

  /**
   * Provide the solution to LeetCode 3146 here:
   * https://leetcode.com/problems/permutation-difference-between-two-strings
   */
  public int findPermutationDifference(String s, String t) {
    int ans = 0;
    int[] indices = new int[26];
    
    for (int i = 0; i < s.length(); ++i){
      indices[s.charAt(i) - 'a'] = i;
    } 

    for (int i = 0; i < t.length(); ++i){
      ans += Math.abs(indices[t.charAt(i) - 'a'] - i);
    } 

    return ans;
  }
}
