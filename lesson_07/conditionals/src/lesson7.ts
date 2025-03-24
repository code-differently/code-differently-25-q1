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
  
if (a < b) return -1;
if (a > b) return 1;

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
    console.error("Factorial is not defined for negative numbers.");
    return -1; 
  }
  if (n === 0 || n === 1) return 1;
  return n * computeFactorial(n - 1);
}

console.log(computeFactorial(-2)); 



/**
 * Returns an array of the first `n` Fibonacci numbers starting from 1.
 *
 * @param n The first `n` of Fibonacci values to compute.
 * @return An array containing the first `n` Fibonacci values.
 */
export function getFirstNFibonacciNumbers(n: number): number[] {
    if (n <= 0) return [];
  if (n === 1) return [1];
  
  const fib: number[] = [1, 1];
  for (let i = 2; i < n; i++) {
    fib.push(fib[i - 1] + fib[i - 2]);
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
export function binarySearch(values: number[], value: number): number {
  let start = 0;
  let end = values.length - 1;

  while (start <= end) {
    let mid = Math.floor((start + end) / 2);

    if (values[mid] === value) {
      return mid; 
    } else if (values[mid] > value) {
      end = mid - 1; 
    } else {
      start = mid + 1; 
    }
  }

  return -1; 
}


