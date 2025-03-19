import * as jest from "@jest/globals";
import { canGetDriverLicense, isStoreOpen, isUppercase } from "./part_e.js";

const describe =
  !process.env.HW_VERSION || process.env.HW_VERSION === "E"
    ? jest.describe
    : jest.describe.skip;

describe("isUppercase", () => {
  it("should return true for uppercase letters", () => {
    expect(isUppercase("A")).toBe(true);
    expect(isUppercase("Z")).toBe(true);
  });

  it("should return false for lowercase letters", () => {
    expect(isUppercase("a")).toBe(false);
    expect(isUppercase("z")).toBe(false);
  });

  it("should return false for non-letter characters", () => {
    expect(isUppercase("1")).toBe(false);
    expect(isUppercase("!")).toBe(false);
  });
});

describe("canGetDriverLicense", () => {
  it("should return true if age is 18 or older and test is passed", () => {
    expect(canGetDriverLicense(18, true)).toBe(true);
    expect(canGetDriverLicense(20, true)).toBe(true);
  });

  it("should return false if age is less than 18", () => {
    expect(canGetDriverLicense(17, true)).toBe(false);
    expect(canGetDriverLicense(16, true)).toBe(false);
  });

  it("should return false if test is not passed", () => {
    expect(canGetDriverLicense(18, false)).toBe(false);
    expect(canGetDriverLicense(20, false)).toBe(false);
  });
});

describe("isStoreOpen", () => {
  it("should return true if the store is open", () => {
    expect(isStoreOpen("Monday", 10)).toBe(true);
    expect(isStoreOpen("Saturday", 15)).toBe(true);
  });

  it("should return false if the store is closed", () => {
    expect(isStoreOpen("Sunday", 10)).toBe(false);
    expect(isStoreOpen("Monday", 8)).toBe(false);
    expect(isStoreOpen("Saturday", 21)).toBe(false);
  });
});
