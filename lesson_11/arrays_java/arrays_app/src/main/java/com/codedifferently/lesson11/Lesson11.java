package com.codedifferently.lesson11;

import java.util.ArrayList;
import java.util.List;

public class Lesson11 {

  public int[] getConcatenation(int[] nums) {
    int answer[] = new int[nums.length * 2];
    for (int i = 0; i < nums.length; i++) {
      answer[i] = nums[i];
      answer[i + nums.length] = nums[i];
    }
    return answer;
  }

  public List<Integer> findWordsContaining(String[] words, char x) {
    var result = new ArrayList<Integer>();
    for (int i = 0; i < words.length; i++) {
      if (words[i].contains(String.valueOf(x))) {
        result.add(i);
      }
    }
    return result;
  }
}
