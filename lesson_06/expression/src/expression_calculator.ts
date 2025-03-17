export class ExpressionCalculator {
  /** Returns a calculation involving a, b, c, d, and e */
  calculate(a: number, b: number, c: number, d: number, e: number): number {
    // Implement your code here to return the correct value.

    // Function to implement: a / b + c * Math.pow(d, e)

    const exponent = this.pow(d, e);
    const division = this.divide(a, b);
    const multiplication = this.multiply(c, exponent);
    const result = this.add(division, multiplication);
    console.log(`Result: ${result}`);
    return result;
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
  pow(base: number, exponent: number): number {
    return Math.pow(base, exponent);
  }
}
