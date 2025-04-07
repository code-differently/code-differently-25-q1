package com.codedifferently.lesson13;

import java.util.HashMap;
import java.util.Map;

public class Lesson13 {

  public int findPermutationDifference(String s, String t) {

    Map<Character, Integer> sIndexMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      sIndexMap.put(s.charAt(i), i);
    }

    int totalDifference = 0;

    for (int i = 0; i < t.length(); i++) {
      char currentChar = t.charAt(i);
      int indexInS = sIndexMap.get(currentChar);
      totalDifference += Math.abs(indexInS - i);
    }

    return totalDifference;
  }
}
