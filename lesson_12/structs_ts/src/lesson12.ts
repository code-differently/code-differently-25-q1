import { ListNode } from './list_node.js';

export class Lesson12 {
  
  public gameResult(head: ListNode | null): string {
     if (!head) return 'Tie';
    
    const ls = [0, 0];
    
    while (head.next) {
        if (head.val !== head.next.val && head.val % 2 === 0) {
            if (head.val > head.next.val) {
                ls[head.val % 2] += 1;
            } else {
                ls[head.next.val % 2] += 1;
            }
        }
        head = head.next;
    }
    
    if (ls[0] === ls[1]) {
        return 'Tie';
    } else if (ls[0] > ls[1]) {
        return 'Even';
    } else {
        return 'Odd';
    }
}
}
