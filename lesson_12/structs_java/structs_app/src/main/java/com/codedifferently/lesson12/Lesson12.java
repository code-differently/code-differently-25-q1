package com.codedifferently.lesson12;

public class Lesson12 {

  /**
   * Provide the solution to LeetCode 3062 here:
   * https://github.com/yang-su2000/Leetcode-algorithm-practice/tree/master/3062-winner-of-the-linked-list-game
   */
  public String gameResult(ListNode head) {
    int[] ls = new int[2];
    while (head != null && head.next != null) {
      // Iterate through the linked list until the second last node
      if (head.val != head.next.val && head.val % 2 == 0) {
        // Check if we have different values and if the current value is even
        if (head.val > head.next.val) {
          ls[head.val % 2] += 1;
        } else {
          ls[head.next.val % 2] += 1;
        }
      }
      head = head.next;
    }

    if (ls[0] > ls[1]) {
      return "Even";
    } else if (ls[0] == ls[1]) {
      return "Tie";
    } else {
      return "Odd";
    }
  }
}
