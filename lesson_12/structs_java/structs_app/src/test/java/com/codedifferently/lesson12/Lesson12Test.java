package com.codedifferently.lesson12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Lesson12Test {

  private ListNode createLinkedList(int[] values) {
    if (values.length == 0) return null;
    ListNode head = new ListNode(values[0]);
    ListNode current = head;
    for (int i = 1; i < values.length; i++) {
      current.next = new ListNode(values[i]);
      current = current.next;
    }
    return head;
  }

  @Test
  public void testGetWinner() {
    Lesson12 solution = new Lesson12();

    // Test case 1
    int[] values1 = {2, 1};
    ListNode head1 = createLinkedList(values1);
    String expected1 = "Even";
    assertEquals(expected1, solution.gameResult(head1));

    // Test case 2
    int[] values2 = {2, 5, 4, 7, 20, 5};
    ListNode head2 = createLinkedList(values2);
    String expected2 = "Odd";
    assertEquals(expected2, solution.gameResult(head2));

    // Test case 3
    int[] values3 = {4, 5, 2, 1};
    ListNode head3 = createLinkedList(values3);
    String expected3 = "Tie"; // Assuming "Even" is the winner in this scenario
    assertEquals(expected3, solution.gameResult(head3));
  }
}
