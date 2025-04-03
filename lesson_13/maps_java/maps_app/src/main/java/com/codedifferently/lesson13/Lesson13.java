package com.codedifferently.lesson13;

import java.util.HashMap;

public class Lesson13 {

  public int findPermutationDifference(String s, String t) {

    HashMap<Character, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      indexMap.put(s.charAt(i), i);
    }
    // calculating the difference
    int difference = 0;
    for (int i = 0; i < t.length(); i++) {
      if (indexMap.containsKey(t.charAt(i))) {
        difference += Math.abs(indexMap.get(t.charAt(i)) - i);
      }
    }
    return difference;
  }
}
// I got help from chat gpt and co pilot. I used chat gpt to further explain the code that I was
// putting in.
