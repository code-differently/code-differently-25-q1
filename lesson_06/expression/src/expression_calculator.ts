export class ExpressionCalculator {
  /** Returns a calculation involving a, b, c, d, and e */
  calculate(a: number, b: number, c: number, d: number, e: number): number {
    // Implement your code here to return the correct value.

    const base: number = this.add(a, b);
    const numerator: number = this.pow(base, c);
    const denominator: number = this.multiply(d, e);
    return this.divide(numerator, denominator);
  }

  add(a: number, b: number): number {
    return a + b;
  }
  pow(base: number, exponent: number): number {
    return Math.pow(base, exponent);
  }
  multiply(a: number, b: number): number {
    return a * b;
  }

  divide(a: number, b: number): number {
    return a / b;
  }
}
