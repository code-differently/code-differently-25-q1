import { ListNode } from './list_node.js';

export class Lesson12 {
  /**
   * Provide the solution to LeetCode 3062 here:
   * https://github.com/yang-su2000/Leetcode-algorithm-practice/tree/master/3062-winner-of-the-linked-list-game
   */
  public gameResult(head: ListNode | null): string {
    let even = 0;
    let odd = 0;
    let evenNode: ListNode | null = head;
    let oddNode: ListNode | null = head?.next ?? null;
    while (evenNode != null && oddNode != null) {
      if (evenNode.val > oddNode.val) {
        even++;
      } else {
        odd++;
      }
      evenNode = evenNode.next?.next ?? null;
      oddNode = oddNode.next?.next ?? null;
    }
    if (even > odd) {
      return 'Even';
    } else if (odd > even) {
      return 'Odd';
    } else {
      return 'Tie';
    }
  }
}
