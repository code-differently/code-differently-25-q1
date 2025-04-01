package com.codedifferently.lesson12;

public class Lesson12 {

  /**
   * Provide the solution to LeetCode 3062 here:
   * https://github.com/yang-su2000/Leetcode-algorithm-practice/tree/master/3062-winner-of-the-linked-list-game
   */
  public String gameResult(ListNode head) {
    int even = 0;
    int odd = 0;
    ListNode evenNode = head;
    ListNode oddNode = (head != null) ? head.next : null;
    while (evenNode != null) {
      if (evenNode.val > oddNode.val) {
        even++;
      } else {
        odd++;
      }
      evenNode = (evenNode.next != null) ? evenNode.next.next : null;
      oddNode = (oddNode.next != null) ? oddNode.next.next : null;
    }
    if (even > odd) {
      return "Even";
    } else if (odd > even) {
      return "Odd";
    } else {
      return "Tie";
    }
  }
}
