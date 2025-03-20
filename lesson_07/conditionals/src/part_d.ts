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
  }
  return false;
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
  switch (true) {
    case a + b > c && a + c > b && b + c > a:
      return true;
    default:
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
  if (isWithinRange(month, 1, 12)) {
    switch (true) {
      case isWithinRange(month, 3, 5):
        return "Spring";
      case isWithinRange(month, 6, 8):
        return "Summer";
      case isWithinRange(month, 9, 11):
        return "Fall";
      default:
        return "Winter";
    }
  }
  return "Invalid month";
}
