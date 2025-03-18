export class ExpressionCalculator {
  /** Returns a calculation involving a, b, c, d, and e */
  calculate(a: number, b: number, c: number, d: number, e: number): number {
    // Implement your code here to return the correct value.
    // a / b + c * Math.pow(d, e),
    const division = this.divide(a, b);
    const exponentation = this.pow(d, e);
    const multiply = this.multiply(c, exponentation);
    const result = this.add(division, multiply);
    return result;
  }

  divide(a: number, b: number): number {
    return a / b;
  }

  pow(base: number, exponent: number): number {
    return Math.pow(base, exponent);
  }
  multiply(c: number, f: number): number {
    return c * f;
  }

  add(num1: number, num2: number): number {
    return num1 + num2;
  }
}
