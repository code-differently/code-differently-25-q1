package com.codedifferently.lesson11;

import java.util.ArrayList;
import java.util.List;

public class Lesson11 {

  public int[] getConcatenation(int[] nums) {
    int n = nums.length;
    int[] result = new int[2 * n];

    for (int i = 0; i < n; i++) {
      result[i] = nums[i];
      result[i + n] = nums[i];
    }

    return result;
  }

  public List<Integer> findWordsContaining(String[] words, char x) {
    List<Integer> indices = new ArrayList<>();

    for (int i = 0; i < words.length; i++) {
      if (words[i].indexOf(x) != -1) {
        indices.add(i);
      }
    }

    return indices;
  }
}
