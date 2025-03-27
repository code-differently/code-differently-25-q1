/**
 * Determine if a number is within the given range.
 *
 * @param num
 * @param min
 * @param max
 * @returns
 */
export function isWithinRange(num: number, min: number, max: number): boolean {
  if (num >= min && num <= max) {
    return true;
  } else {
    return false;
  }
}

/**
 * Determine if a shape is a triangle based on the given side lengths.
 *
 * @param a
 * @param b
 * @param c
 * @returns
 */
export function isValidTriangle(a: number, b: number, c: number): boolean {
  /* a + b > c
  a + c > b
  b + c > a*/
  if (a + b > c && a + c > b && b + c > a) {
    return true;
  } else {
    return false;
  }
}

/**
 * Determines what season it is based on the given month, or returns "Invalid month"
 * if the month is invalid. Month numbers range from 1 to 12.
 *
 * @param month
 * @returns
 */
export function getSeason(month: number): string {
  if (month === 1 || month === 2 || month === 12) {
    return "Winter";
  }
  if (month === 3 || month === 4 || month === 5) {
    return "Spring";
  }
  if (month === 6 || month === 7 || month === 8) {
    return "Summer";
  }
  if (month === 9 || month === 10 || month === 11) {
    return "Fall";
  } else {
    return "Invalid month";
  }
}
