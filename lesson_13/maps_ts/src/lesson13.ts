/**
 * Provide the solution to LeetCode 3146 here:
 * https://leetcode.com/problems/permutation-difference-between-two-strings
 */
export function findPermutationDifference(s: string, t: string): number {
  let difference = 0;
  for (let i = 0; i < s.length; i++) {
    //for loop is to itirate through the string
    difference += Math.abs(i - t.indexOf(s[i])); // Add absolute differences using an Indexof function
    // Co pilot fixed my error. I had charAt originally it would not pass
  }
  return difference;
}
