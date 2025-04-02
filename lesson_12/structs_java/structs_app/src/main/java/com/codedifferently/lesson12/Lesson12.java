package com.codedifferently.lesson12;

public class Lesson12 {

  /**
   * Provide the solution to LeetCode 3062 here:
   * https://github.com/yang-su2000/Leetcode-algorithm-practice/tree/master/3062-winner-of-the-linked-list-game
   */
  public String gameResult(ListNode head) {
    int even = 0;
    int odd = 0;

    while (head != null) {
      if (head.val > head.next.val) {
        even++;

      } else if (head.val < head.next.val) {
        odd++;
      }
      head = head.next.next;
    }
    if (even > odd) {
      return "Even";
    }
    if (even < odd) {
      return "Odd";
    }
    return "Tie";
  }
}
