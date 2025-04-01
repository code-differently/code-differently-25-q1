import { ListNode } from './list_node.js';

export class Lesson12 {
  /**
   * Provide the solution to LeetCode 3062 here:
   * https://github.com/yang-su2000/Leetcode-algorithm-practice/tree/master/3062-winner-of-the-linked-list-game
   */
  public gameResult(head: ListNode | null): string {
    let evenScore = 0,
      oddScore = 0;
    let curr = head;

    while (curr !== null && curr.next !== undefined) {
      const evenVal = curr.val;
      const oddVal = curr.next.val;

      if (evenVal > oddVal) {
        evenScore++;
      } else {
        oddScore++;
      }

      curr = curr.next?.next ?? null;
    }
    if (evenScore > oddScore) {
      return 'Even';
    } else if (oddScore > evenScore) {
      return 'Odd';
    }
    return 'Tie';
  }
}
