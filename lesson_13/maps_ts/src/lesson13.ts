/**
 * Provide the solution to LeetCode 3146 here:
 * https://leetcode.com/problems/permutation-difference-between-two-strings
 */
export function findPermutationDifference(s: string, t: string): number {
  // used chat gpt for this solution implementation
    
  // variable difference keeps track of absolute difference between character index
  let difference = 0;
    
    // creating a map to store the index of each character in s
    const positionMap: Record<string, number> = {};
    // iterating through the characters in s with i as the index
    for (let i = 0; i < s.length; i++) {
      // returns the character at a given index 
        positionMap[s[i]] = i;
    }
    
    // calculating permutation difference
    for (let i = 0; i < t.length; i++) {
      //using a built in function - math.abs to calculate the difference in character index
      // index of character in string s - index of character in string i
        difference += Math.abs(i - positionMap[t[i]]);
    }
    
    return difference;
}

