package com.codedifferently.lesson12;

public class Lesson12 {

  public String gameResult(ListNode head) {
    int evenNumbers = 0;
    int oddNumbers = 0;

    ListNode current = head;

    // While "current" does not strictly equal null & current.next does not strictly equal null, the
    // current value is evenVariable, & oddVariable is the next value.
    while (current != null && current.next != null) {
      int evenVariable = current.val;
      int oddVariable = current.next.val;

      if (oddVariable > evenVariable) {
        oddNumbers++;
      } else if (evenVariable > oddVariable) {
        evenNumbers++;
      }

      current = current.next.next;
    }

    if (oddNumbers > evenNumbers) {
      return "Odd";
    } else if (evenNumbers > oddNumbers) {
      return "Even";
    } else {
      return "Tie";
    }
  }
}
