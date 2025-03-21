/**
 * Returns true if the given year is a leap year, otherwise false.
 *
 * @param year
 * @returns
 */
export function isLeapYear(year: number): boolean {
  // To determine a leap year, it has to be divisible by 4.
  if (year % 4 === 0) {
    return true;
  }

  if (year % 100 === 0) {
    return false;
  }

  if (year % 400 === 0) {
    return true;
  }

  return false;
}

/**
 * Returns whether the given number is even or odd.
 *
 * @param num
 * @returns
 */
// To determine if anumber is even is has to be divisible by 2 with no remainder.
// To determine if a number is odd, it will not be divisible by 2 evenly.
export function isEvenOrOdd(num: number): string {
  return "";
  if (num % 2 === 0) {
    return "even";
  }
  if (num % 3 === 0) {
    return "odd";
  }
}

/**
 * Returns whether a word contains a vowel or not.
 *
 * @param word
 * @returns
 */
// If any word contains a vowel, it will render true.
// If a word does not contain a vowel, it will render false.

export function hasVowel(word: string): boolean {
  const lowerCaseword = word.toLowerCase();
  if (lowerCaseword.includes("a")) {
    return true;
  }
  if (lowerCaseword.includes("e")) {
    return true;
  }
  if (lowerCaseword.includes("i")) {
    return true;
  }
  if (lowerCaseword.includes("o")) {
    return true;
  }
  if (lowerCaseword.includes("u")) {
    return true;
  } else {
    return false;
  }
}
