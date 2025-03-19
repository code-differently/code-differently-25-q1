export class ExpressionCalculator {
  /** Returns a calculation involving a, b, c, d, and e */
  calculate(a: number, b: number, c: number, d: number, e: number): number {
    // Implement your code here to return the correct value.
    const addition = this.add(a, b);
    const multiplication = this.multiply(addition, c);
    const power = this.pow(d, e);
    const division = this.divide(multiplication, power);
    return division;
    //return (this.add(a, b) * c) / this.pow(d, e);
  }

  // Function to be implemented: (a + b) * c / Math.pow(d, e)

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


//end of file//
