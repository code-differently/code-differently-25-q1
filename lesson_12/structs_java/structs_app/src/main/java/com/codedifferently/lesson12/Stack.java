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
    if (top == null) {
      top = newNode;
    } else {
      ListNode temp = top;
      top = newNode;
      top.next = temp;
    }
  }

  public int pop() {
    if (top != null) {
      int value = top.val;
      top = top.next;
      return value;
    } else {
      return -1;
    }
  }

  public int peek() {
    if (top != null) {
      return top.val;
    } else {
      throw new RuntimeException("Stack is empty");
        
    }
  }

  public boolean isEmpty() {
    if (top == null) {
      return true;
    } else {
      return false;
    }
  }
}
