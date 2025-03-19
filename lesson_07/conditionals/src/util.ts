/**
 * Computes a score describing the lexicographic distance between two strings. For two strings of
 * equal length, the score will be the difference between the first differing character. In the
 * case where either is a sub-string of the other, then the difference in length determines the
 * score.
 *
 * @param a The first string to compare.
 * @param b The second string to compare.
 * @return A score representing the lexicographic distance between two strings.
 */
export function computeLexicographicDistance(a: string, b: string): number {
  const minLength = Math.min(a.length, b.length);
  for (let i = 0; i < minLength; i++) {
    if (a[i] !== b[i]) {
      return a.charCodeAt(i) - b.charCodeAt(i);
    }
  }
  return a.length - b.length;
}
