export class ExpressionCalculator {
  /** Returns a calculation involving a, b, c, d, and e */
  calculate(a: number, b: number, c: number, d: number, e: number): number {
    // Function to implement: a * Math.pow(b + c, d) / e
    const addition = this.add(b, c);
    const exponentiation = this.pow(addition, d);
    const multiplication = this.multiply(a, exponentiation);
    const division = this.divide(multiplication, e);
    return division;
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
