import { ListNode } from './list_node.js';

export class Lesson12 {
  /**
   * Provide the solution to LeetCode 3062 here:
   * https://github.com/yang-su2000/Leetcode-algorithm-practice/tree/master/3062-winner-of-the-linked-list-game
   */
  public gameResult(head: ListNode | null): string {
    const ls: number[] = [0, 0]; //Sets list to only represent numbers
    while (head && head.next) {
      //Goes through linked list until there are no more numbers
      if (head.val !== head.next.val && head.val % 2 === 0) {
        //determines if we have different numbers as well as if head number is divisible by 2
        if (head.val > head.next.val) {
          //Checks if the number was even and is greater than second number
          ls[head.val % 2] += 1; //If both were true this function occurs and gives even a point
        } else {
          ls[head.next.val % 2] += 1; //If either are false then give odd a point
        }
      }
      head = head.next; //Proceed to next node/set of numbers to continue unil we are out of pairs
    }

    if (ls[0] > ls[1]) {
      //Tells us the result based on which list[] got the point vvv
      return 'Even';
    } else if (ls[0] === ls[1]) {
      return 'Tie';
    } else {
      return 'Odd';
    }
  }
}
