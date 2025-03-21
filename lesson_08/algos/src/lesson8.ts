function run(): void {
  console.log("The permutations of 'abc' are:");
  printPermutations('abc', '');

  console.log();
  console.log("The reverse of 'abc' is: " + reverseString('abc'));
}

/**
 * Prints all the permutations of a string.
 *
 * @param value The string to permute.
 * @param answer The current permutation.
 */
function printPermutations(value: string, answer: string): void {
  if (value.length === 0) {
    console.log(answer);
    return;
  }

  for (let i = 0; i < value.length; i++) {
    const ch = value.charAt(i);
    const left = value.substring(0, i);
    const right = value.substring(i + 1);
    const rest = left + right;
    printPermutations(rest, answer + ch);
  }
}

/**
 * Reverses a string by swapping the front half of the characters with the back half.
 *
 * @param input The string to reverse.
 * @return The reversed string.
 */
function reverseString(input: string): string {
  if (input.length === 0) {
    return input;
  }

  const charArray = input.split('');

  for (let i = 0; i < charArray.length / 2; i++) {
    // Compute the corresponding index from the back of the string.
    const j = charArray.length - i - 1;
    swapCharacters(charArray, i, j);
  }

  return charArray.join('');
}

/**
 * Swaps the characters in the provided character array.
 *
 * @param charArray
 * @param i
 * @param j
 */
function swapCharacters(charArray: string[], i: number, j: number): void {
  const temp = charArray[i];
  charArray[i] = charArray[j];
  charArray[j] = temp;
}

// Execute the main `run` method.
run();
