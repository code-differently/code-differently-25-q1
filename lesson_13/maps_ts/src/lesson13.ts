/**
 * Provide the solution to LeetCode 3146 here:
 * https://leetcode.com/problems/permutation-difference-between-two-strings
 */
export function findPermutationDifference(s: string, t: string): number {
  let total = 0;

  for (let i = 0; i < s.length; i++) {
    const ch = s.charAt(i);
    const idx2 = t.indexOf(ch);

    total += Math.abs(i - idx2);
  }
  return total;
}
