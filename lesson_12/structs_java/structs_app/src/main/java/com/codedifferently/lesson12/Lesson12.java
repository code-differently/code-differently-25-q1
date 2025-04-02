package com.codedifferently.lesson12;

public class Lesson12 {

  /**
   * Provide the solution to LeetCode 3062 here:
   * https://github.com/yang-su2000/Leetcode-algorithm-practice/tree/master/3062-winner-of-the-linked-list-game
   */
  public String gameResult(ListNode head) {
    
    //team values
    int oddValue = 0;
    int evenValue = 0;

    //iterate through listNode
    //grabbed items
    //accessed value

    while (head != null && head.next != null) {
      int val1 = head.val; //at head node, accessing value. head val is even
      int val2 = head.next.val; // at next node, accessing value. next val is odd

      //compare values
      if (val1 > val2) {
         evenValue += 1;
      } else if (val1 < val2) {
        oddValue += 1;
      }
      // go to next value
        
    }
    






    // loop through lstNode
    
    // grab lstNode values
    //compare them
    //return even or odd depending on which value is higher

  
  

  }

}
