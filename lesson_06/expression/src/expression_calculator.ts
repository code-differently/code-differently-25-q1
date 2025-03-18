export class ExpressionCalculator {
  /** Returns a calculation involving a, b, c, d, and e */
  calculate(a: number, b: number, c: number, d: number, e: number): number {
    // Implement your code here to return the correct value.
    //(Math.pow(a, b) + c) * d / e
    const exponential = this.pow(a, b);
    const addition = this.add(exponential, c);
    const multiply = this.multiply(addition, d);
    const divide = this.divide(multiply, e);
    // const divide = this.divide(multiply, e);
    return divide;
   
  }

  pow(base: number, exponent: number): number {
    return Math.pow(base, exponent);
  }
  add(number1: number, number2: number): number {
    return number1 + number2;
  } 
  multiply(number1: number, number2: number): number {
    return number1 * number2;
  }
  divide(number1: number, number2: number): number {
    return number1 / number2;
  }
}
