import * as jest from "@jest/globals";
import { getSeason, isValidTriangle, isWithinRange } from "./part_d.js";

const describe =
  !process.env.HW_VERSION || process.env.HW_VERSION === "D"
    ? jest.describe
    : jest.describe.skip;

describe("isWithinRange", () => {
  it("should return true if the number is within the range", () => {
    expect(isWithinRange(5, 1, 10)).toBe(true);
    expect(isWithinRange(1, 1, 10)).toBe(true);
    expect(isWithinRange(10, 1, 10)).toBe(true);
  });

  it("should return false if the number is outside the range", () => {
    expect(isWithinRange(0, 1, 10)).toBe(false);
    expect(isWithinRange(11, 1, 10)).toBe(false);
  });
});

describe("isValidTriangle", () => {
  it("should return true for valid triangles", () => {
    expect(isValidTriangle(3, 4, 5)).toBe(true);
    expect(isValidTriangle(5, 12, 13)).toBe(true);
    expect(isValidTriangle(7, 24, 25)).toBe(true);
  });

  it("should return false for invalid triangles", () => {
    expect(isValidTriangle(1, 1, 2)).toBe(false);
    expect(isValidTriangle(1, 2, 3)).toBe(false);
    expect(isValidTriangle(5, 1, 1)).toBe(false);
  });
});
describe("getSeason", () => {
  it("should return 'Winter' for months 12, 1, and 2", () => {
    expect(getSeason(12)).toBe("Winter");
    expect(getSeason(1)).toBe("Winter");
    expect(getSeason(2)).toBe("Winter");
  });

  it("should return 'Spring' for months 3, 4, and 5", () => {
    expect(getSeason(3)).toBe("Spring");
    expect(getSeason(4)).toBe("Spring");
    expect(getSeason(5)).toBe("Spring");
  });

  it("should return 'Summer' for months 6, 7, and 8", () => {
    expect(getSeason(6)).toBe("Summer");
    expect(getSeason(7)).toBe("Summer");
    expect(getSeason(8)).toBe("Summer");
  });

  it("should return 'Fall' for months 9, 10, and 11", () => {
    expect(getSeason(9)).toBe("Fall");
    expect(getSeason(10)).toBe("Fall");
    expect(getSeason(11)).toBe("Fall");
  });

  it("should return 'Invalid month' for months outside the range 1-12", () => {
    expect(getSeason(0)).toBe("Invalid month");
    expect(getSeason(13)).toBe("Invalid month");
    expect(getSeason(-1)).toBe("Invalid month");
  });
});
