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
    if (this.top === null) {
      throw new Error('Empty List');
    }
    if (this.top !== undefined) {
      return this.top.val;
    }
    throw new Error('Empty List');
  }

  isEmpty(): boolean {
    return this.top === undefined;
  }
}
