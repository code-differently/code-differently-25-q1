package com.codedifferently.lesson12;

public class Lesson12 {

  /**
   * Provide the solution to LeetCode 3062 here:
   * https://github.com/yang-su2000/Leetcode-algorithm-practice/tree/master/3062-winner-of-the-linked-list-game
   */
  public String gameResult(ListNode head) {
    int oddValue = 0; 
    int evenValue = 0;

    while(head != null && head.next != null) {
      int i = head.val;
      int j = head.next.val;

      if (i < j) {
        oddValue += 1;
      } else if (i > j){
        evenValue += 1;
      }
      head = head.next.next;
    }
  
    if (oddValue > evenValue) {
      return "Odd";
    } else if (evenValue > oddValue) {
        return "Even";
    } else {
      return "Tie";
    }
  }
}
