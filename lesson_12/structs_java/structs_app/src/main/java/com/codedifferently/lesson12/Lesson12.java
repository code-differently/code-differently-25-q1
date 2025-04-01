package com.codedifferently.lesson12;

public class Lesson12 {

  // public static Node {
  //   public int data;
  //   public Node next;

  //   public Node(int data) {
  //     this.data = data;
  //   }
  // }
  /**
   * Provide the solution to LeetCode 3062 here:
   * https://github.com/yang-su2000/Leetcode-algorithm-practice/tree/master/3062-winner-of-the-linked-list-game
   */
  public static String gameResult(ListNode head) {
    int[] scoreBoard = {0, 0};

    while (head.next != null) {
      if (head.val != head.next.val && head.val % 2 == 0) {
        if (head.val > head.next.val) {
          scoreBoard[head.val % 2] += 1;
        } else {
          scoreBoard[head.next.val % 2] += 1;
        }
      }
      head = head.next; // Moves to the next Node
    }

    if (scoreBoard[0] == scoreBoard[1]) {
      return "Tie";
    } else if (scoreBoard[0] > scoreBoard[1]) {
      return "Even";
    } else {
      return "Odd";
    }
  }
}

  // public static Node createLinkedList(int[] arr) {
  //   if (arr.length == 0) return null;

  //   Node head = new Node(arr[0]); //Creates the first node and names it head
  //   Node current = head; //Tracks the current head inside the loop

  //   for(int i = 1; i < arr.length; ++i) { //Starts a for loop that is at the second element
  //     current.next = new Node(arr[i]); //creates a new node and links it
  //     current = current.next;
  //   }
  //       return head;

  // }

  // public static void main(String[] args) {
  //     int[] arr = {2, 5, 4, 7, 20, 5};

  //     System.out.println(createLinkedList(arr));
  // }
// }
