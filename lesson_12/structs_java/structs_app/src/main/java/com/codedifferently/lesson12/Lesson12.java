package com.codedifferently.lesson12;

public class Lesson12 {

  /**
   * Provide the solution to LeetCode 3062 here:
   * https://github.com/yang-su2000/Leetcode-algorithm-practice/tree/master/3062-winner-of-the-linked-list-game
   */
  public String gameResult(ListNode head) {

    // ititialize counter for even and odd team
    int evenTeam = 0;
    int oddTeam = 0;

    // iterate through listNode
    while (head != null && head.next != null) {
      int headNode = head.val; // grabbed head node, accessing value. head val is even
      int nextNode = head.next.val; // grabbed next node, accessing value. next val is odd

      // used AI for this part of implementation
      // compare values
      if (headNode > nextNode) {
        evenTeam += 1;
      } else if (headNode < nextNode) {
        oddTeam += 1;
      }
      // go to next value
      head = head.next.next;

      // used AI for this part of the implementation
      // return statements for whichever team wins
      if (evenTeam > oddTeam) {
        return "Even team wins!";
      } else if (oddTeam > evenTeam) {
        return "Odd team wins!";
      } else {
        return "It's a tie!";
      }
    }
    return "Even team wins!";
  }
}
