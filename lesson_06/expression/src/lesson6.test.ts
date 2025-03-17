import { jest } from "@jest/globals";
import type { Calculator } from "./calculator.js";
import { ExpressionCalculator } from "./expression_calculator.js";
import { FUNCTIONS } from "./functions.js";

describe("Lesson6Test", () => {
  let calculator: Calculator;

  beforeEach(() => {
    calculator = new ExpressionCalculator() as Calculator;
  });

  test("testCalculate", () => {
    // Arrange
    const a = 1;
    const b = 2;
    const c = 3;
    const d = 4;
    const e = 5;
    const expected = FUNCTIONS[process.env.HW_VERSION || ""].call(
      null,
      ...[a, b, c, d, e],
    );
    jest.spyOn(calculator, "add");
    jest.spyOn(calculator, "multiply");
    jest.spyOn(calculator, "divide");
    jest.spyOn(calculator, "pow");

    // Act
    const actual = calculator.calculate(a, b, c, d, e);

    // Assert
    expect(actual).toBeCloseTo(expected);
    expect(calculator.add).toHaveBeenCalledTimes(1);
    expect(calculator.multiply).toHaveBeenCalledTimes(1);
    expect(calculator.divide).toHaveBeenCalledTimes(1);
    expect(calculator.pow).toHaveBeenCalledTimes(1);
  });

  test("testAdd_works", () => {
    // Act
    const result = calculator.add(1, 2);

    // Assert
    expect(result).toBe(3);
  });

  test("testMultiply_works", () => {
    // Act
    const result = calculator.multiply(1, 2);

    // Assert
    expect(result).toBe(2);
  });

  test("testDivide_works", () => {
    // Act
    const result = calculator.divide(1, 2);

    // Assert
    expect(result).toBeCloseTo(0.5);
  });

  test("testPow_works", () => {
    // Act
    const result = calculator.pow(2, 3);

    // Assert
    expect(result).toBe(8);
  });
});
