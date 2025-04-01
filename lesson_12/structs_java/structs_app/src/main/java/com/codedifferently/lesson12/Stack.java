package com.codedifferently.lesson12;

/** Implement the below Stack by providing code for the class methods. */
public class Stack {
  private ListNode top;

  public Stack() {
    this.top = null;
  }

  public void push(int value) {
    ListNode newNode = new ListNode(value); // Will create a new node
    newNode.next = top; // Point the new node to the top of the Stack
    top = newNode; // Changes the top node to become newNode
  }

  public int pop() {
    int value = top.val; // gets the value of top and creating it as a variable value that will temporarily
    // store it
    top = top.next; // Move top to the next position in the stack this instance it would be whatever
    // is below the top node.
    return value; // returns that temporary saved val varaible and removes from the stack
  }

  public int peek() {
    return top.val; // Will return the top val of the stack "peeking in"
  }

  public boolean isEmpty() {
    return top == null; // returns true is the top of the stack is empty aka null
  }
}
