package com.codedifferently.lesson12;

public class Lesson12 {

  /**
   * Provide the solution to LeetCode 3062 here:
   * https://github.com/yang-su2000/Leetcode-algorithm-practice/tree/master/3062-winner-of-the-linked-list-game
   */
  public String gameResult(ListNode head) {
    int odd = 0, even = 0;
    for (; head != null; head = head.next.next) {
      int a = head.val;
      int b = head.next.val;
      odd += a < b ? 1 : 0;
      even += a > b ? 1 : 0;
    }
    if (odd > even) {
      return "Odd";
    }
    if (odd < even) {
      return "Even";
    }
    return "Tie";
  }
}
