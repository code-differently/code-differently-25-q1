package com.codedifferently.lesson13;

public class Lesson13 {

  /**
   * Provide the solution to LeetCode 3146 here:
   * https://leetcode.com/problems/permutation-difference-between-two-strings
   */
  public int findPermutationDifference(String s, String t) {
    // I create a hashmap called "tBys" (convention) that I store the key-value pairs of s & t into.
    java.util.Map<Character, Integer> tBys = new java.util.HashMap<>();

    // This variable will take in the difference for each index after every iteration, eventually
    // giving the complete sum of them all.
    int accumulationVariable = 0;
    int permDifference = 0;
    // NOTE: I use accumulationVariable for my own personal convention.

    // This for loop is actually what goes through the string s & puts each key-value into the
    // variable tBys, which is now an object.
    for (int i = 0; i < s.length(); i++) {
      // Puts these key-values into the tBys map.
      tBys.put(s.charAt(i), i);
    }

    // This for loop goes through the string t and will use the key to get the value of the tBys
    // object.
    for (int i = 0; i < t.length(); i++) {

      // Assigns the character at index i to currentChar. For iteration 1, that would be character
      // b.
      char currentChar = t.charAt(i); // This is character 'b' in string t.

      // .get() gets the index value from currentChar, which in turn gives the index value for s.
      // currentChar is b for iteration 1 (in string t), because the index of 0 for the t string is
      // b. If I were to try and translate this line into plain english, it would look something
      // like this: "Using string t as a reference, go and GET the 'b' from the t string. This
      // letter will reference the 'b' in string s, giving us index 1 from string s being assigned
      // to sIndex."
      int sIndex = tBys.get(currentChar); // This is index 1 from string s, aka 'b'.

      // Because the problem wants the absolute difference between the index of s & t, we will
      // simply use the Math.abs method to get the absolute value of each integer. Each distance
      // equation is represented by being placed inside 2 verticle bars (|99-99|). sIndex - i would
      // give us the difference between each index after every loop. The i simply represents the
      // next letter that we're supposed to compare.
      accumulationVariable +=
          Math.abs(
              sIndex - i); // This is simply the position of s minus the position of t. i finds a
      // letter in t, takes that index, then subtracts it by the index of the
      // letter that it's looking for.
    }
    permDifference = accumulationVariable;
    return permDifference; // Returns the full permutation difference after the loops have run their
    // course.
  }
}
