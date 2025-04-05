package com.codedifferently.lesson12;

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
    if (isEmpty()) {
      throw new RuntimeException("Stack Underflow: Cannot pop from an empty stack");
    }
    int poppedValue = top.val;
    top = top.next;
    return poppedValue;
  }

  public int peek() {
    if (isEmpty()) {
      throw new RuntimeException("Stack is empty: Cannot peek");
    }
    return top.val;
  }

  public boolean isEmpty() {
    return top == null;
  }

  public void printStack() {
    ListNode current = top;
    while (current != null) {
      System.out.print(current.val + " -> ");
      current = current.next;
    }
    System.out.println("null");
  }
}
