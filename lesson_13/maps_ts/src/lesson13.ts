/**
 * Provide the solution to LeetCode 3146 here:
 * https://leetcode.com/problems/permutation-difference-between-two-strings
 */
export function findPermutationDifference(s: string, t: string): number {
  let ans = 0;

  for (let i = 0; i < s.length; i++) {
    const ch = s.charAt(i);
    const index = t.indexOf(ch);

    ans += Math.abs(i - index);
  }
  return ans;
}
