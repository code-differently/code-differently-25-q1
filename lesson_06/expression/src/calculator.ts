export interface Calculator {
  calculate(a: number, b: number, c: number, d: number, e: number): number;
  add(a: number, b: number): number;
  multiply(a: number, b: number): number;
  divide(a: number, b: number): number;
  pow(base: number, exponent: number): number;
}
