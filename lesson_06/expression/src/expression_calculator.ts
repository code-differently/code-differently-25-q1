export class ExpressionCalculator {
  /** Returns a calculation involving a, b, c, d, and e */
  calculate(a: number, b: number, c: number, d: number, e: number): number {
    // Implement your code here to return the correct value.

    //Function to implement: a * b / Math.pow(c + d, e)

    const addition = this.add(c, d);
    const multiplication = this.multiply(a, b);
    const exponent = this.pow(addition, e);
    const division = this.divide(multiplication, exponent);
    return division;
  }

  pow(base: number, exponent: number): number {
    return Math.pow(base, exponent);
  }

  add(a: number, b: number): number {
    return a + b;
  }
  divide(a: number, b: number): number {
    return a / b;
  }
  subtract(a: number, b: number): number {
    return a - b;
  }
  multiply(a: number, b: number): number {
    return a * b;
  }
}
