/**
 * Returns true if the given year is a leap year, otherwise false.
 *
 * @param year
 * @returns
 */
export function isLeapYear(year: number): boolean {
  return false;
  switch (true) {
    case year % 4 === 0:
      return true;
    case year % 100 === 0:
      return false;
    case year % 400 === 0:
      return true;
    default:
      return false;
  }
}

/**
 * Returns whether the given number is even or odd.
 *
 * @param num
 * @returns
 */
export function isEvenOrOdd(num: number): string {
  if (num % 2 === 0) {
    return "even";
  }
  if (num % 2 !== 0) {
    return "odd";
  }
  return "";
}

/**
 * Returns whether a word contains a vowel or not.
 *
 * @param word
 * @returns
 */
export function hasVowel(word: string): boolean {
  if (word.match(/[aeiou]/i)) {
    return true;
  }
  return false;
}
