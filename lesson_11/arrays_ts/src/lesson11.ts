/**
 * Provide the solution to LeetCode 1929 here:
 * https://leetcode.com/problems/concatenation-of-array
 */
export function getConcatenation(nums: number[]): number[] {
 const result: number[] = new Array(nums.length * 2); // Create a new array of double the length of nums
    
    for (let i = 0; i < nums.length; i++) {
        result[i] = nums[i]; // First half of the result array
        result[i + nums.length] = nums[i]; // Second half of the result array
    }
    
    return result;
}

/**
 * Provide the solution to LeetCode 2942 here:
 * https://leetcode.com/problems/find-words-containing-character/
 */
export function findWordsContaining(words: string[], x: string): number[] {
 const result: number[] = []; 
    for (let i = 0; i < words.length; i++) {
        if (words[i].includes(x)) { // Check if character 'x' is present in the word
            result.push(i); // Add the index of the word to the result
        }
    }
    return result;
}
