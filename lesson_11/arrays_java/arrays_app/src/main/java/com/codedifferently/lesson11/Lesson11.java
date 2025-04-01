package com.codedifferently.lesson11;

import java.util.ArrayList;
import java.util.List;

public class Lesson11 {

  /**
   * Provide the solution to LeetCode 1929 here:
   * https://leetcode.com/problems/concatenation-of-array
   */
  public int[] getConcatenation(int[] nums) {
    int n = nums.length; // Puts length of nums case into n.
    int[] ans = new int[2 * n]; // Declares ans as an array with 6 values.

    // Puts whatever is placed on the index number in each num[i] position and copies it to the
    // ans[i] position > depending on what [i] is at the time.
    for (int i = 0; i < n; i++) {
      ans[i] = nums[i];
    }

    // Same thing as the last one, but with the starting position being on whatever index n is on.
    // In this case, it's starting at index 3, aka, position 4. This is where the concatenation part
    // happens.
    for (int i = 0; i < n; i++) {
      ans[i + n] = nums[i];
    }
    // Side note...I'm not sure if this happens after the first 3 numbers have been added, during
    // each loop, or after.

    return ans;
  }

  /**
   * Provide the solution to LeetCode 2942 here:
   * https://leetcode.com/problems/find-words-containing-character/
   */
  public List<Integer> findWordsContaining(String[] words, char x) {
    List<Integer> result = new ArrayList<>();

    // Iterating through the array.
    for (int i = 0; i < words.length; i++) {
      if (words[i].indexOf(x)
          != -1) { // If a particular index contains x, and it does not strictly equal -1 (aka, an
        // index that doesn't exist)...
        result.add(i); // Then append the index at the end of the list.
      }
    }

    return result; // Return the index of x in an array.
  }
}
