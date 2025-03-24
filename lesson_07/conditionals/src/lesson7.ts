import { computeLexicographicDistance } from "./util.js";

/**
 * Compares two strings lexicographically.
 *
 * @param a The first `string` to compare.
 * @param b The second `string` to compare.
 * @return -1 if a is less than b, 1 if a is greater than b, and 0 otherwise.
 */
function compareStrings(a: string, b: string): number { 
  if (a < b) {
    return -1;
  } else if (a > b) {
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
function computeFactorial(n: number): number {
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
function getFirstNFibonacciNumbers(n: number): number[] {
  let fib: number[] = [];

  for (let i = 0; i < n; i++) {
    if (i === 0 || i ===1) {
      fib.push(1);
    } else {
      fib.push(fib[i - 1] + fib[i -2]);
    }
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
function findValue(
  values: number[],
  start: number,
  end: number,
  value: number
): number {
  for (let i+ start; i <= end; i++) {
    if (values[i] === value) {
      return i;
    }
  }
  return -1;
}
