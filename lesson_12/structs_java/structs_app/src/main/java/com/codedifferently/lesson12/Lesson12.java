package com.codedifferently.lesson12;

public class Lesson12 {
  /**
   * Provide the solution to LeetCode 3062 here:
   * https://github.com/yang-su2000/Leetcode-algorithm-practice/tree/master/3062-winner-of-the-linked-list-game
   */
  public static String gameResult(ListNode head) {
    int[] scoreBoard = {0, 0}; //Creates an array that will act as our scoreboard...hence the name

    while (head.next != null) { //Creates a loop that runs until the head Linked list is empty || null
      if (head.val != head.next.val && head.val % 2 == 0) { //Checks if the current node's value is not equal to the node next to it.
      //Also will check if the current not's value is even ( % 2 dividing by 2 to detemine)
        if (head.val > head.next.val) {//Updates the array based on index.
          scoreBoard[head.val % 2] += 1;  //If the head is divisible by 2 then update the first Even teams point
        } else {
          scoreBoard[head.next.val % 2] += 1; 
        }
      }
      head = head.next; // Moves to the next Node
    }

    if (scoreBoard[0] == scoreBoard[1]) {
      return "Tie"; //Returns tie if the scoreboard is even
    } else if (scoreBoard[0] > scoreBoard[1]) {
      return "Even"; //if the Even side [0] is greater than 1 return "Even"
    } else {
      return "Odd"; // Else return "Odd"
    }
  }
}
