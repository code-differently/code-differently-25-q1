package com.codedifferently.lesson12;

public class Lesson12 {

  /**
   * Provide the solution to LeetCode 3062 here:
   * https://github.com/yang-su2000/Leetcode-algorithm-practice/tree/master/3062-winner-of-the-linked-list-game
   */
  public String gameResult(ListNode head) {
    int evenPoints = 0, oddPoints = 0;
    ListNode current = head;

    while (current != null && current.next != null) {
      if (current.val > current.next.val) {
        evenPoints++;
      } else {
        oddPoints++;
      }
      current = current.next.next; 
    }

    if (evenPoints > oddPoints) {
      return "Even";
    } else if (oddPoints > evenPoints) {
      return "Odd";
    } else {
      return "Tie";
    }
  }
}

