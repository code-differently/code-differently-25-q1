export const FUNCTIONS: Record<string, (...args: number[]) => number> =
  Object.freeze({
    A: (a: number, b: number, c: number, d: number, e: number) =>
      ((a + b) * c) / Math.pow(d, e),
    B: (a: number, b: number, c: number, d: number, e: number) =>
      Math.pow(a + b, c) / (d * e),
    C: (a: number, b: number, c: number, d: number, e: number) =>
      a / b + c * Math.pow(d, e),
    D: (a: number, b: number, c: number, d: number, e: number) =>
      (a * b) / Math.pow(c + d, e),
    E: (a: number, b: number, c: number, d: number, e: number) =>
      Math.pow((a + b) / c, d) * e,
    F: (a: number, b: number, c: number, d: number, e: number) =>
      (a * Math.pow(b + c, d)) / e,
    G: (a: number, b: number, c: number, d: number, e: number) =>
      ((Math.pow(a, b) + c) * d) / e,
  });
