package com.codedifferently.lesson12;

public class Stack {
  private ListNode top;

  private static class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public Stack() {
    this.top = null;
  }

  public void push(int value) {
    ListNode newNode = new ListNode(value);
    newNode.next = top;
    top = newNode; // This will update top to the new node.
  }

  public int pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    int poppedValue = top.value;
    top = top.next;
    return poppedValue;
  }

  public int peek() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    return top.value;
  }

  public boolean isEmpty() {
    return top == null;
  }
}
