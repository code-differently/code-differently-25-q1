import { computeLexicographicDistance } from "./util.js";

/**
 * Compares two strings lexicographically.
 *
 * @param a The first `string` to compare.
 * @param b The second `string` to compare.
 * @return -1 if a is less than b, 1 if a is greater than b, and 0 otherwise.
 */
export function compareStrings(a: string, b: string): number {
  // The distance will be a number less than 0 if string `a` is lexicographically less than `b`, 1
  // if it is greater, and 0 if the strings are equal.
  const distance = computeLexicographicDistance(a, b);

  // TODO(you): Finish this method.
  if (distance < 0) return -1;
  if (distance > 0) return 1;
  return 0;
}

/**
 * Computes the factorial of the given value of `n`.
 *
 * @param n The value for which to compute the factorial.
 * @return The factorial of n.
 */
export function computeFactorial(n: number): number {
  if (n < 0) {
    throw new Error("Factorial is not defined for negative numbers.");
  }
  if (n === 0 || n === 1) {
    return 1;
  }

  let result = 1;
  for (let i = 2; i <= n; i++) {
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
  if (n===0) {
    return []
  }
  const fibNum = [1, 1];
  for (let i = 2; i < n; i++) {
    fibNum.push(fibNum[i - 1] + fibNum[i - 2])
  }
  return fibNum; 
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
    // The range is not valid so just return -1.
    return -1;
  }

  const pivotIndex = Math.floor((start + end) / 2); // The index in the middle of the array.
  if (values[pivotIndex] === value) {
    return pivotIndex; // Value found at pivot index.
  } else if (values[pivotIndex] > value) {
    return binarySearch(values, start, pivotIndex - 1, value); // Search left half.
  } else {
    return binarySearch(values, pivotIndex + 1, end, value); // Search right half.
  }
}

// TODO(you): Finish implementing this algorithm

// If values[pivotIndex] is equal to value then return `pivotIndex`.
// Else if values[pivotIndex] is greater than the value, then
// call `binarySearch(values, start, pivotIndex - 1, value)` and return its value;
// Else call `binarySearch(values, pivotIndex + 1, end, value)` and return its value.
