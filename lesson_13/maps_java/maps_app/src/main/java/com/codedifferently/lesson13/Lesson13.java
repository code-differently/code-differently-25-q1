package com.codedifferently.lesson13;

import java.util.HashMap;

public class Lesson13 {

  /**
   * Provide the solution to LeetCode 3146 here:
   * https://leetcode.com/problems/permutation-difference-between-two-strings
   */
  public int findPermutationDifference(String s, String t) {
    HashMap<Character, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      indexMap.put(s.charAt(i), i);
    }
    int difference = 0;

    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);
      int originalIndex = indexMap.get(ch);
      difference += Math.abs(originalIndex - i);
    }
    return difference;
  }

  // used chatgpt because I needed help creating an instance before calling
  public static void main(String[] args) {
    // Create an object of Lesson13 to call the method
    Lesson13 obj = new Lesson13();
    System.out.println(obj.findPermutationDifference("abc", "bac")); // Output: 2
    System.out.println(obj.findPermutationDifference("abcde", "edbac")); // Output: 12
  }
}
// Constraints:
// 1 <= s.length <= 26
// Each character occurs at most once in s.
// t is a permutation of s.
// s consists only of lowercase English letters.
