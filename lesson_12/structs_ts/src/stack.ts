import { ListNode } from './list_node.js';

export class Stack {
  private top: ListNode | undefined;

  constructor() {
    this.top = undefined;
  }

  push(value: number): void {
    throw new Error('Not implemented');
  }

  pop(): number | undefined {
    throw new Error('Not implemented');
  }

  peek(): number | null {
    throw new Error('Not implemented');
  }

  isEmpty(): boolean {
    throw new Error('Not implemented');
  }
}
