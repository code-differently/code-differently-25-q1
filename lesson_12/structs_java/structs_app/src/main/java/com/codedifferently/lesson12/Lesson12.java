package com.codedifferently.lesson12;

public class Lesson12 {

  public String gameResult(ListNode head) {
    int evenScore = 0;
    int oddScore = 0;

    while (head != null && head.next != null) {
      int current = head.val;
      int next = head.next.val;

      if (current != next && current % 2 == 0) {
        if (current > next) {
          evenScore++;
        } else {
          oddScore++;
        }
      }

      head = head.next;
    }

    if (evenScore == oddScore) {
      return "Tie";
    } else if (evenScore > oddScore) {
      return "Even";
    } else {
      return "Odd";
    }
  }
}
