package com.codedifferently.lesson12;

/** Implement the below Stack by providing code for the class methods. */
public class Stack {
  private ListNode top;

  public Stack() {
    this.top = null;
  }

  public void push(int value) {
    ListNode newNode = new ListNode(value);
    // putting ontop of stack
    newNode.next = top;
    // setting top as new node
    top = newNode;
  }

  public int pop() {
    // checking to see if top is null
    if (top == null) {
      throw new IllegalStateException("stack is empty");
    }
    // created a varible to store current value
    int value = top.val;
    // remove the top
    top = top.next;
    return value;
  }

  public int peek() {
    if (top == null) {
      throw new IllegalStateException("stack is empty");
    }

    return top.val;
  }

  public boolean isEmpty() {
    if (top == null) {
      return true;
    } else {
      return false;
    }
  }
}

