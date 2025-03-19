export class ExpressionCalculator {
  /** Returns a calculation involving a, b, c, d, and e */
  calculate(a: number, b: number, c: number, d: number, e: number): number {
    // Implement your code here to return the correct value.
    const addition = this.add(a, b);
    // const multiplication2 = this.multiply(addition, c);
    // console.log(multiplication2);
    const multiplication = this.multiply(addition, c);
    const exponent = this.pow(d, e);
    const division = this.divide(multiplication, exponent);
    return division;
  }
  // Function to implement: (a + b) * c / Math.pow(d, e)

  pow(base: number, exponent: number): number {
    return Math.pow(base, exponent);
  }

  add(a: number, b: number): number {
    return a + b;
  }

  multiply(a: number, c: number): number {
    return a * c;
  }

  divide(a: number, b: number): number {
    return a / b;
  }


    // A: (a: number, b: number, c: number, d: number, e: number) =>
    //   ((a + b) * c) / Math.pow(d, e),
}
