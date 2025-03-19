export class ExpressionCalculator {
  add(a: number, b: number): number {
    return a + b;
  }
  pow(base: number, exponent: number): number {
    return Math.pow(base, exponent);
  }
  divide(a: number, b: number): number {
    /*if (denominator === 0) {
      throw new Error("Cannot divide by zero");
    }
    */return a / b;
  }

  multiply(a: number, b: number): number {
    return a * b;
  }
  calculate(a: number, b: number, c: number, d: number, e: number): number {
    const sumResult = this.add(a, b);
    const divisionResult = this.divide(sumResult, c);
    const powerResult = this.pow(c, d);
    const multiplication = this.multiply(divisionResult, e);
    console.log({ sumResult, powerResult, divisionResult, });
    return multiplication
  }
  }
