import { Stack } from './stack.js';

describe('Stack', () => {
  test('testPush', () => {
    const stack = new Stack();
    stack.push(1);
    expect(stack.peek()).toBe(1);
  });

  test('testPop', () => {
    const stack = new Stack();
    stack.push(1);
    stack.push(2);
    expect(stack.pop()).toBe(2);
    expect(stack.pop()).toBe(1);
  });

  test('testTop', () => {
    const stack = new Stack();
    stack.push(1);
    stack.push(2);
    expect(stack.peek()).toBe(2);
    stack.pop();
    expect(stack.peek()).toBe(1);
  });

  test('testIsEmpty', () => {
    const stack = new Stack();
    expect(stack.isEmpty()).toBe(true);
    stack.push(1);
    expect(stack.isEmpty()).toBe(false);
    stack.pop();
    expect(stack.isEmpty()).toBe(true);
  });

  test('testTopEmptyStack', () => {
    const stack = new Stack();
    expect(() => stack.peek()).toThrow();
  });
});
