import { ListNode } from './list_node.js';

export class Stack {
  private top: ListNode | null;

  constructor() {
    this.top = null;
  }

  push(value: number): void {
    const newNode = new ListNode(value, this.top ?? undefined);
    this.top = newNode;
  }

  pop(): number {
    if (this.isEmpty()) {
      throw new Error('Stack Underflow: Cannot pop from an empty stack');
    }
    // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
    const poppedValue = this.top!.val;
    this.top = this.top?.next ?? null;
    return poppedValue;
  }

  peek(): number {
    if (this.isEmpty()) {
      throw new Error('Stack is empty: Cannot peek');
    }
    // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
    return this.top!.val;
  }

  isEmpty(): boolean {
    return this.top === null;
  }
}
