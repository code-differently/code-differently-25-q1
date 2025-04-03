import { expect, test } from '@jest/globals';
import { Lesson12 } from './lesson12.js';
import { ListNode } from './list_node.js';

function createLinkedList(values: number[]): ListNode | null {
  if (values.length === 0) return null;
  const head = new ListNode(values[0]);
  let current = head;
  for (let i = 1; i < values.length; i++) {
    current.next = new ListNode(values[i]);
    current = current.next;
  }
  return head;
}

test('testGetWinner', () => {
  const solution = new Lesson12();

  // Test case 1
  const values1 = [2, 1];
  const head1 = createLinkedList(values1);
  const expected1 = 'Even';
  expect(solution.gameResult(head1)).toBe(expected1);

  // Test case 2
  const values2 = [2, 5, 4, 7, 20, 5];
  const head2 = createLinkedList(values2);
  const expected2 = 'Odd';
  expect(solution.gameResult(head2)).toBe(expected2);

  // Test case 3
  const values3 = [4, 5, 2, 1];
  const head3 = createLinkedList(values3);
  const expected3 = 'Tie'; // Assuming "Even" is the winner in this scenario
  expect(solution.gameResult(head3)).toBe(expected3);
});
