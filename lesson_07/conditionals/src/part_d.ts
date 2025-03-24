/**
 * Determine if a number is within the given range.
 *
 * @param num
 * @param min
 * @param max
 * @returns
 */
function isWithinRange(num: number, min: number, max: number): boolean {
  return num >= min && num <= max;
}  

console.log(isWithinRange(7, 5, 10));
console.log(isWithinRange(2, 5, 10));

/**
 * Determine if a shape is a triangle based on the given side lengths.
 *
 * @param a
 * @param b
 * @param c
 * @returns
 */
function isValidTriangle(a: number, b: number, c: number): boolean {
  return a + b > c && a + c > b && b + c > a;
}

/**
 * Determines what season it is based on the given month, or returns "Invalid month"
 * if the month is invalid. Month numbers range from 1 to 12.
 *
 * @param month
 * @returns
 */
function getSeason(month: number): string {
  if (month >= 3 && month <= 5) {
    return "Spring";
  } else if (month >= 6 && month <= 8) {
    return "Summer";
  } else if (month >= 9 && month <= 11) {
    return "Fall";
  } else if (month === 12 || month === 1 || month === 2) {
    return "Winter";
  } else {
    return "Invalid month";
  }
}