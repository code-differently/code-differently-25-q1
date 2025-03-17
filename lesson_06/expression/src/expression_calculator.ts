export class ExpressionCalculator {
  /** Returns a calculation involving a, b, c, d, and e */
  calculate(a: number, b: number, c: number, d: number, e: number): number {
    // Implement your code here to return the correct value.
    const base: number = this.add(b, c);
    const expo: number = d;

    return this.divide(this.multiply(a, this.pow(base, expo)), e);
  }

  pow(base: number, exponent: number): number {
    return Math.pow(base, exponent);
  }
  add(a: number, b: number): number {
    return a + b;
  }
  multiply(a: number, b: number): number {
    return a * b;
  }
  divide(a: number, b: number): number {
    return a / b;
  }
}
