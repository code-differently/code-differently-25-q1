package com.codedifferently.lesson11;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class Lesson11Test {

  @Test
  public void testGetConcatenation() {
    Lesson11 solution = new Lesson11();

    // Test case 1
    int[] nums1 = {1, 2, 1};
    int[] expected1 = {1, 2, 1, 1, 2, 1};
    int[] result1 = solution.getConcatenation(nums1);
    assertArrayEquals(expected1, result1);

    // Test case 2
    int[] nums2 = {1, 3, 2, 1};
    int[] expected2 = {1, 3, 2, 1, 1, 3, 2, 1};
    int[] result2 = solution.getConcatenation(nums2);
    assertArrayEquals(expected2, result2);

    // Test case 3
    int[] nums3 = {};
    int[] expected3 = {};
    int[] result3 = solution.getConcatenation(nums3);
    assertArrayEquals(expected3, result3);

    // Test case 4
    int[] nums4 = {5};
    int[] expected4 = {5, 5};
    int[] result4 = solution.getConcatenation(nums4);
    assertArrayEquals(expected4, result4);

    // Test case 5
    int[] nums5 = {0, 0, 0};
    int[] expected5 = {0, 0, 0, 0, 0, 0};
    int[] result5 = solution.getConcatenation(nums5);
    assertArrayEquals(expected5, result5);
  }

  @Test
  public void testWordsContainingChar() {
    Lesson11 solution = new Lesson11();

    // Test case 1
    char ch1 = 'a';
    String[] words1 = {"apple", "banana", "cherry", "date"};
    List<Integer> expected1 = Arrays.asList(0, 1, 3);
    List<Integer> result1 = solution.findWordsContaining(words1, ch1);
    assertEquals(expected1, result1);

    // Test case 2
    char ch2 = 'z';
    String[] words2 = {"apple", "banana", "cherry", "date"};
    List<Integer> expected2 = Arrays.asList();
    List<Integer> result2 = solution.findWordsContaining(words2, ch2);
    assertEquals(expected2, result2);

    // Test case 3
    char ch3 = 'e';
    String[] words3 = {"apple", "banana", "cherry", "date"};
    List<Integer> expected3 = Arrays.asList(0, 2, 3);
    List<Integer> result3 = solution.findWordsContaining(words3, ch3);
    assertEquals(expected3, result3);

    // Test case 4
    char ch4 = 'a';
    String[] words4 = {"", " ", "banana"};
    List<Integer> expected4 = Arrays.asList(2);
    List<Integer> result4 = solution.findWordsContaining(words4, ch4);
    assertEquals(expected4, result4);
  }
}
