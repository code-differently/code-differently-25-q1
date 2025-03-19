import * as jest from "@jest/globals";
import { addNumbers, canVote, computeFactorial } from "./part_a.js";

const describe =
  !process.env.HW_VERSION || process.env.HW_VERSION === "A"
    ? jest.describe
    : jest.describe.skip;

describe("canVote", () => {
  describe("canVote", () => {
    test("returns true for age 18", () => {
      expect(canVote(18)).toBe(true);
    });

    test("returns true for age greater than 18", () => {
      expect(canVote(20)).toBe(true);
    });

    test("returns false for age less than 18", () => {
      expect(canVote(17)).toBe(false);
    });
  });

  describe("addNumbers", () => {
    test("returns 0 for an empty array", () => {
      expect(addNumbers([])).toBe(0);
    });

    test("returns the sum of all numbers in the array", () => {
      expect(addNumbers([1, 2, 3, 4, 5])).toBe(15);
    });

    test("returns the correct sum for negative numbers", () => {
      expect(addNumbers([-1, -2, -3, -4, -5])).toBe(-15);
    });
  });

  describe("computeFactorial", () => {
    test("returns 1 for n = 0", () => {
      expect(computeFactorial(0)).toBe(1);
    });

    test("returns the correct factorial for positive n", () => {
      expect(computeFactorial(5)).toBe(120);
    });

    test("returns 1 for n = 1", () => {
      expect(computeFactorial(1)).toBe(1);
    });
  });
});
