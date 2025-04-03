package com.codedifferently.lesson13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Lesson13Test {

  @Test
  public void testPermutationDifference() {
    Lesson13 solution = new Lesson13();

    // Test case 1
    String s1_1 = "abc";
    String s2_1 = "bca";
    assertEquals(4, solution.findPermutationDifference(s1_1, s2_1));

    // Test case 2
    String s1_2 = "abc";
    String s2_2 = "abc";
    assertEquals(0, solution.findPermutationDifference(s1_2, s2_2));

    // Test case 3
    String s1_3 = "abcd";
    String s2_3 = "abdc";
    assertEquals(2, solution.findPermutationDifference(s1_3, s2_3));

    // Test case 4
    String s1_4 = "rwohu";
    String s2_4 = "rwuoh";
    assertEquals(4, solution.findPermutationDifference(s1_4, s2_4));
  }
}
