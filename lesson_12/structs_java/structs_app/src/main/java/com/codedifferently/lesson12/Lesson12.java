package com.codedifferently.lesson12;

public class Lesson12 {

  /**
   * Provide the solution to LeetCode 3062 here:
   * https://github.com/yang-su2000/Leetcode-algorithm-practice/tree/master/3062-winner-of-the-linked-list-game
   */
  public String gameResult(ListNode head) {
    int evenTeam = 0;
    int oddTeam = 0;

    while (head !=null && head.next != null) {
      int current = head.val;
      int next = head.next.val;

      if (current != next && current %2 == 0) {
        if (current > next) {
          evenTeam++;
        } else {
          oddTeam++;
        }
      }
  
      head = head.next;
    }

    if (evenTeam == oddTeam) {
      return "Tie";
    } else if (evenTeam > oddTeam) {
      return "Even";
    } else {
      return "Odd";
    }
  }
}
