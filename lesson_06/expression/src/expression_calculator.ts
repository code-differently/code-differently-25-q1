export class ExpressionCalculator {
  /** Returns a calculation involving a, b, c, d, and e */
  calculate(a: number, b: number, c: number, d: number, e: number): number {
    // Implement your code here to return the correct value.
    return (a * this.pow(b + c, d)) / e;
  }

  pow(base: number, exponent: number): number {
    return Math.pow(base, exponent);
  }
}
