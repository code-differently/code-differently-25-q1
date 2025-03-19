import * as jest from "@jest/globals";
import { getDayOfWeek, getTicketPrice, isStrongPassword } from "./part_c.js";

const describe =
  !process.env.HW_VERSION || process.env.HW_VERSION === "C"
    ? jest.describe
    : jest.describe.skip;

describe("isStrongPassword", () => {
  it("should return true for a strong password", () => {
    expect(isStrongPassword("StrongPass1")).toBe(true);
  });

  it("should return false for a password with less than 8 characters", () => {
    expect(isStrongPassword("Short1")).toBe(false);
  });

  it("should return false for a password without an uppercase letter", () => {
    expect(isStrongPassword("weakpassword1")).toBe(false);
  });

  it("should return false for a password without a digit", () => {
    expect(isStrongPassword("WeakPassword")).toBe(false);
  });
});

describe("getDayOfWeek", () => {
  it("should return 'Sunday' for 0", () => {
    expect(getDayOfWeek(0)).toBe("Sunday");
  });

  it("should return 'Monday' for 1", () => {
    expect(getDayOfWeek(1)).toBe("Monday");
  });

  it("should return 'Tuesday' for 2", () => {
    expect(getDayOfWeek(2)).toBe("Tuesday");
  });

  it("should return 'Wednesday' for 3", () => {
    expect(getDayOfWeek(3)).toBe("Wednesday");
  });

  it("should return 'Thursday' for 4", () => {
    expect(getDayOfWeek(4)).toBe("Thursday");
  });

  it("should return 'Friday' for 5", () => {
    expect(getDayOfWeek(5)).toBe("Friday");
  });

  it("should return 'Saturday' for 6", () => {
    expect(getDayOfWeek(6)).toBe("Saturday");
  });

  it("should return an empty string for an invalid day", () => {
    expect(getDayOfWeek(7)).toBe("");
  });
});

describe("getTicketPrice", () => {
  it("should return 0 for children under 5 years old", () => {
    expect(getTicketPrice(4)).toBe(0);
  });

  it("should return 10 for children between 5 and 17 years old", () => {
    expect(getTicketPrice(10)).toBe(10);
  });

  it("should return 20 for adults between 18 and 59 years old", () => {
    expect(getTicketPrice(30)).toBe(20);
  });

  it("should return 15 for seniors 60 years old and older", () => {
    expect(getTicketPrice(65)).toBe(15);
  });
});
