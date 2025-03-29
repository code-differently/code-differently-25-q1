package com.codedifferently.lesson11;

import java.util.ArrayList;
import java.util.List;

public class Lesson11 {

  /**
   * Provide the solution to LeetCode 1929 here:
   * https://leetcode.com/problems/concatenation-of-array
   */
  public static int[] getConcatenation(int[] nums) {

    int n = nums.length; // Creates a variable named n that is the length of nums
    int[] ans = new int[2 * n]; // Creates a new array that is double the size of n.

    for (int i = 0; i < n; ++i) {
      ans[i] = nums[i]; // Gets the first half of the int array
      ans[i + n] = nums[i]; // Gets the second half of the int array
    }
    return ans;
  }

  public static void main(String[] args) {

    // Creates an instance of the solution class
    // We need this because getConcatenation() is a method that is non-static meaning we need and
    // object of Solution to use it.
    // This would be unneeded if getConcatenation() was static

    int[] nums = {1, 2, 3, 4}; // Array of nums based on Test input
    int[] result =
        getConcatenation(nums); // calls the getConcatenation method giving it the array of nums.

    // Prints result out.

    // You need to loop out the result because we want to display the contents of an array which
    // means we need to call each instance in it. This is easily done by using the for else loop to
    // run until it is returned false.
    for (int num : result) {
      System.out.print(num + " ");
    }

    String[] words = {
      "leet", "code", "hello", "world"
    }; // Creates an Array named words that contains a series of strings.[]

    char x = 'e'; // Calls for a specific char
    System.out.println(findWordsContaining(words, x)); // Prints out findWordsContaining method
  }

  /**
   * Provide the solution to LeetCode 2942 here:
   * https://leetcode.com/problems/find-words-containing-character/
   */
  public static List<Integer> findWordsContaining(String[] words, char x) {
    ArrayList<Integer> elListo = new ArrayList<>(); // Create an arraylist named ElListo

    // Runs a loop that will iterate through each character in the word.
    for (int i = 0; i < words.length; i++) {
      if (words[i].indexOf(x) != -1) { // will check to see if 'x' exists inside of the word
        elListo.add(i); // Stores the index if it is true that it has that character
      }
    }
    return elListo; // Will return elListo ArrayList to main
  }
}
