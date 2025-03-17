export class ExpressionCalculator {
  /** Returns a calculation involving a, b, c, d, and e */

  add(a: number, b: number): number {
    return a + b;
  }

  multiply(a: number, b: number): number {
    return a * b;
  }

  divide(a: number, b: number): number {
    if (b === 0) throw new Error("Cannot divide by zero");
    return a / b;
  }

  pow(base: number, exponent: number): number {
    return Math.pow(base, exponent);
  }

  calculate(a: number, b: number, c: number, d: number, e: number): number {
    return this.multiply(a, this.divide(this.pow(this.add(b, c), d), e));
  }
}
