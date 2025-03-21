import { computeLexicographicDistance } from "./util.js";

/**
 * Compares two strings lexicographically.
 *
 * @param a The first `string` to compare.
 * @param b The second `string` to compare.
 * @return -1 if a is less than b, 1 if a is greater than b, and 0 otherwise.
 */
export function compareStrings(a: string, b: string): number {
  const distance = computeLexicographicDistance(a, b);

  if (distance < 0) {
    return -1;
  } else if (distance > 0) {
    return 1;
  } else {
    return 0;
  }
}

/**
 * Computes the factorial of the given value of `n`.
 *
 * @param n The value for which to compute the factorial.
 * @return The factorial of n.
 */
export function computeFactorial(n: number): number {
  if (n === 0) {
    return 1;
  }

  let result = 1;
  for (let i = 1; i <= n; i++) {
    result *= i;
  }

  return result;
}

/**
 * Returns an array of the first `n` Fibonacci numbers starting from 1.
 *
 * @param n The first `n` of Fibonacci values to compute.
 * @return An array containing the first `n` Fibonacci values.
 */
export function getFirstNFibonacciNumbers(n: number): number[] {
  if (n <= 0) return [];

  const fib: number[] = [1];

  if (n === 1) return fib;

  fib.push(1); // Add the second 1

  for (let i = 2; i < n; i++) {
    const next = fib[i - 1] + fib[i - 2];
    fib.push(next);
  }

  return fib;
}

/**
 * Finds a value in an array of values.
 *
 * @param values The values to search.
 * @param start The left most index to search.
 * @param end The right most index to search.
 * @param value The value to look for.
 * @return The index of the value if found in the array and -1 otherwise.
 */
export function binarySearch(
  values: number[],
  start: number,
  end: number,
  value: number,
): number {
  if (end < start) {
    return -1; // Base case: value not found
  }

  const pivotIndex = Math.floor((start + end) / 2);

  if (values[pivotIndex] === value) {
    return pivotIndex;
  } else if (values[pivotIndex] > value) {
    return binarySearch(values, start, pivotIndex - 1, value);
  } else {
    return binarySearch(values, pivotIndex + 1, end, value);
  }
}
