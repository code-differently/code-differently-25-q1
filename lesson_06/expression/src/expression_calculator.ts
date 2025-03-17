export class ExpressionCalculator {
  /** Returns a calculation involving a, b, c, d, and e */
  calculate(a: number, b: number, c: number, d: number, e: number): number {
    // Implement your code here to return the correct value.
    // (a + b) * c / Math.pow(d, e)
    const additionVariable = this.add(a, b);
    const multiplicationVariable = this.multiply(additionVariable, c);
    const powerVariable = this.pow(d, e);
    const dividingVariable = this.divide(multiplicationVariable, powerVariable);
    return dividingVariable;
  }

  add(a: number, b: number): number {
    return a + b;
  }

  multiply(num1: number, num2: number): number {
    return num1 * num2;
  }

  pow(base: number, exponent: number): number {
    return Math.pow(base, exponent);
  }

  divide(a: number, b: number): number {
    return a / b;
  }
}
