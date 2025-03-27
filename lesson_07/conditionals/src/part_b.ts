/**
 * Returns true if the given year is a leap year, otherwise false.
 *
 * @param year
 * @returns
 */
export function isLeapYear(year: number): boolean {
  if (year % 400 === 0) {
    return true;
  } else if (year % 100 === 0) {
    return false;
  } else if (year % 4 === 0) {
    return true;
  } else {
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
  } else {
    return "odd";
  }
}

/**
 * Returns whether a word contains a vowel or not.
 *
 * @param word
 * @returns
 */
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
