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
  if (a + b > c || a + c > b || b + c > a) {
    return true;
  }
  return false;
}

/**
 * Determines what season it is based on the given month, or returns "Invalid month"
 * if the month is invalid. Month numbers range from 1 to 12.
 *
 * @param month
 * @returns
 */
export function getSeason(month: number): string {
  const winter: number[] = [12, 1, 2];
  const spring: number[] = [3, 4, 5];
  const summer: number[] = [6, 7, 8];
  const fall: number[] = [9, 10, 11];

  for (const num of winter) {
    if (num === month) {
      return "Winter";
    }
  }

  for (const num of spring) {
    if (num === month) {
      return "Spring";
    }
  }

  for (const num of summer) {
    if (num === month) {
      return "Summer";
    }
  }

  for (const num of fall) {
    if (num === month) {
      return "Fall";
    }
  }

  return "Invalid month";
}
