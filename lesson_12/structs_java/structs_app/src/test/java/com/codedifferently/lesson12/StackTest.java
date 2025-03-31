package com.codedifferently.lesson12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StackTest {

  @Test
  public void testPush() {
    Stack stack = new Stack();
    stack.push(1);
    assertEquals(1, stack.peek());
  }

  @Test
  public void testPop() {
    Stack stack = new Stack();
    stack.push(1);
    stack.push(2);
    assertEquals(2, stack.pop());
    assertEquals(1, stack.pop());
  }

  @Test
  public void testTop() {
    Stack stack = new Stack();
    stack.push(1);
    stack.push(2);
    assertEquals(2, stack.peek());
    stack.pop();
    assertEquals(1, stack.peek());
  }

  @Test
  public void testIsEmpty() {
    Stack stack = new Stack();
    assertTrue(stack.isEmpty());
    stack.push(1);
    assertFalse(stack.isEmpty());
    stack.pop();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void testTopEmptyStack() {
    Stack stack = new Stack();
    assertThrows(
        Exception.class,
        () -> {
          stack.peek();
        });
  }
}
