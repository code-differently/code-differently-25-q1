import { ListNode } from './list_node.js';

export class Lesson12 {
  /**
   * Provide the solution to LeetCode 3062 here:
   * https://github.com/yang-su2000/Leetcode-algorithm-practice/tree/master/3062-winner-of-the-linked-list-game
   */
  public gameResult(head: ListNode | null): string {
    const scoreBoard = [0, 0];

    while (head?.next != null) {
      if(head?.val != head?.next?.val && head?.val % 2 == 0) {
        if(head?.val > head?.next.val) {
          scoreBoard[head?.val % 2] += 1;
        } else {
          scoreBoard[head?.next.val % 2] +=1;
        }
      }
      head = head?.next;
    }

    if (scoreBoard[0] == scoreBoard[1]) {
      return 'Tie';
    } else if (scoreBoard[0] > scoreBoard[1]) {
      return 'Even';
    } else {
      return 'Odd';
    }
  }
}
