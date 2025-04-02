package com.codedifferently.lesson12;

import java.util.EmptyStackException;

/** Implement the below Stack by providing code for the class methods. */
public class Stack {
  private ListNode top;

  public Stack() {
    this.top = null;
  }

  public void push(int value) {
    ListNode newNode = new ListNode(value);
    newNode.next = top;
    top = newNode;
  }

  public int pop() {
    if (top == null) {
      throw new EmptyStackException();
    }
    int poppedval = top.val;
    top = top.next;
    return poppedval;
  }

  public int peek() {
    if (top == null) {
      throw new EmptyStackException();
    }
    return top.val;
  }

  public boolean isEmpty() {
    if (top == null) {
      return true;
    } else return false;
  }
}
