package com.codedifferently.lesson12;

/** Implement the below Stack by providing code for the class methods. */
public class Stack {
  private ListNode top;

  public Stack() {
    this.top = null;
  }

  public void push(int value) {
    // Your code here
    ListNode newNode = new ListNode(value);
    newNode.next = top;
    top = newNode;
  }

  public int pop() {
    int val = top.val;
    top = top.next;
    return val;
  }

  public int peek() {
    if (isEmpty()) {
      throw new IllegalStateException("Empty List");
    }
    return top.val;
  }

  public boolean isEmpty() {
    return top == null;
  }
}
