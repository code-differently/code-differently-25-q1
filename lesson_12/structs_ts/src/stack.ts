import { ListNode } from './list_node.js';

export class Stack {
  private top: ListNode | undefined;

  constructor() {
    this.top = undefined;
  }

  push(value: number): void {
    const newNode: ListNode | undefined = new ListNode(value);
    newNode.next = this.top;
    this.top = newNode;
  }

  pop(): number | undefined {
    if (this.top === null) {
      return undefined;
    }
    const val = this.top?.val;
    this.top = this.top?.next;
    return val;
  }

  peek(): number | null {
    if (this.top === undefined) {
      throw new Error('Empty List');
    }
    return this.top.val;
  }

  isEmpty(): boolean {
    return this.top === undefined;
  }
}
