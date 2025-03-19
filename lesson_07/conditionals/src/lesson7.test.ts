import {
  binarySearch,
  compareStrings,
  getFirstNFibonacciNumbers,
} from "./lesson7.js";

describe("Lesson7 Tests", () => {
  test("testCompareStrings", () => {
    // Test when both strings are equal
    expect(compareStrings("hello", "hello")).toBe(0);

    // Test when the first string is less than the second string
    expect(compareStrings("apple", "banana")).toBe(-1);

    // Test when the first string is greater than the second string
    expect(compareStrings("banana", "apple")).toBe(1);
  });

  test("testGetFirstNFibonacciNumbers", () => {
    // Test for n = 0
    expect(getFirstNFibonacciNumbers(0)).toEqual([]);

    // Test for n = 5
    expect(getFirstNFibonacciNumbers(5)).toEqual([1, 1, 2, 3, 5]);

    // Test for n = 10
    expect(getFirstNFibonacciNumbers(10)).toEqual([
      1, 1, 2, 3, 5, 8, 13, 21, 34, 55,
    ]);
  });

  test("testBinarySearch", () => {
    const values = [1, 3, 5, 7, 9];

    // Test for value present in the array
    expect(binarySearch(values, 0, values.length - 1, 1)).toBe(0);
    expect(binarySearch(values, 0, values.length - 1, 3)).toBe(1);
    expect(binarySearch(values, 0, values.length - 1, 5)).toBe(2);
    expect(binarySearch(values, 0, values.length - 1, 7)).toBe(3);
    expect(binarySearch(values, 0, values.length - 1, 9)).toBe(4);

    // Test for value not present in the array
    expect(binarySearch(values, 0, values.length - 1, 4)).toBe(-1);
  });
});
