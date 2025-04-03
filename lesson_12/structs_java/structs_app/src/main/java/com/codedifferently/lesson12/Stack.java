package com.codedifferently.lesson12;

/** Implement the below Stack by providing code for the class methods. */
public class Stack {
  private ListNode top; // set top to ListNode

  // constructor method. initializes top
  public Stack() {
    this.top = null;
  }

  public void push(int value) {
    // creating new list node
    ListNode newNode = new ListNode(value);
    // setting new node to point to top
    newNode.next = top;
    // settng new node to top node
    top = newNode;
  }

  // used AI for this method implementation
  public int pop() {
    // if stack is empty
    if (isEmpty()) {
      // return this object with this statement
      throw new IllegalStateException("Stack is empty");
    }
    // gets top value
    int value = top.val;
    // moves top to next node
    top = top.next;
    // returns popped value
    return value;
  }

  public int peek() { // returns top element withouut removing it
    return top.val;
  }

  public boolean isEmpty() {
    return top == null;
  }
}
