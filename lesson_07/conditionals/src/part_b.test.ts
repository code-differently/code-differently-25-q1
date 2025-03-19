import * as jest from "@jest/globals";
import { hasVowel, isEvenOrOdd, isLeapYear } from "./part_b.js";

const describe =
  !process.env.HW_VERSION || process.env.HW_VERSION === "B"
    ? jest.describe
    : jest.describe.skip;

describe("isLeapYear", () => {
  test("returns true for leap years divisible by 400", () => {
    expect(isLeapYear(2000)).toBe(true);
    expect(isLeapYear(1600)).toBe(true);
  });

  test("returns false for years divisible by 100 but not by 400", () => {
    expect(isLeapYear(1900)).toBe(false);
    expect(isLeapYear(2100)).toBe(false);
  });

  test("returns true for years divisible by 4 but not by 100", () => {
    expect(isLeapYear(1996)).toBe(true);
    expect(isLeapYear(2004)).toBe(true);
  });

  test("returns false for years not divisible by 4", () => {
    expect(isLeapYear(1999)).toBe(false);
    expect(isLeapYear(2001)).toBe(false);
  });
});

describe("isEvenOrOdd", () => {
  test("returns 'even' for even numbers", () => {
    expect(isEvenOrOdd(2)).toBe("even");
    expect(isEvenOrOdd(4)).toBe("even");
  });

  test("returns 'odd' for odd numbers", () => {
    expect(isEvenOrOdd(1)).toBe("odd");
    expect(isEvenOrOdd(3)).toBe("odd");
  });
});

describe("hasVowel", () => {
  test("returns true for words containing vowels", () => {
    expect(hasVowel("apple")).toBe(true);
    expect(hasVowel("orange")).toBe(true);
  });

  test("returns false for words without vowels", () => {
    expect(hasVowel("rhythm")).toBe(false);
    expect(hasVowel("crypt")).toBe(false);
  });
});
