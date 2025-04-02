package com.codedifferently.lesson11;

import java.util.ArrayList;
import java.util.List;

public class Lesson11 {

  /**
   * Provide the solution to LeetCode 1929 here:
   * https://leetcode.com/problems/concatenation-of-array
   */
  public static int[] getConcatenation(int[] nums) {
    // Creates a variable named n that is the length of nums
    int n = nums.length;
    // Creates a new array that is double the size of n.
    int[] ans = new int[2 * n];

    for (int i = 0; i < n; ++i) {
      // Gets the first half of the int array
      ans[i] = nums[i];
      // Gets the second half of the int array
      ans[i + n] = nums[i];
    }
    return ans;
  }

  public static List<Integer> findWordsContaining(String[] words, char x) {
    // Create an arraylist named arrList
    ArrayList<Integer> arrList = new ArrayList<>();

    // Runs a loop that will iterate through each character in the word.
    for (int i = 0; i < words.length; i++) {
      // will check to see if 'x' exists inside of the word
      if (words[i].indexOf(x) != -1) {
        // Stores the index if it is true that it has that character
        arrList.add(i);
      }
    }
    return arrList;
  }
}
