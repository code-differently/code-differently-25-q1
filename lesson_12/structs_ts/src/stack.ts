import { ListNode } from './list_node.js';

export class Stack {
  private top: ListNode | undefined;

  constructor() {
    this.top = undefined;
  }

  push(value: number): void {
    const newNode = new ListNode(value);
    newNode.next = this.top;
    this.top = newNode;
  }

  pop(): number | undefined {
    const current = this.top;
    
    this.top = this.top?.next;
    
    return current?.val;
  }

  peek(): number | null {
    if (this.top === undefined) {
      throw new Error('Invalid Sytanx');
    }
    return this.top.val;
  }

  isEmpty(): boolean {
    return this.top == null;
  }
}
