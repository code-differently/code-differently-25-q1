export class ExpressionCalculator {
  pow(base: number, exponent: number): number {
    return Math.pow(base, exponent);
  }
  add(a: number, b: number): number {
    return a + b;
  }
  divide(a: number, b: number): number {
    return a / b;
  }
  multiply(a: number, b: number): number {
    return a * b;
  }

  /** Returns a calculation involving a, b, c, d, and e */
  calculate(a: number, b: number, c: number, d: number, e: number): number {
    const addition = this.add(a, b);
    const division = this.divide(addition, c);
    const exponent = this.pow(division, d);
    const multiplication = this.multiply(exponent, e);
    return multiplication;
  }
}
