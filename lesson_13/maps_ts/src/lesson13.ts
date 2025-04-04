export function findPermutationDifference(s: string, t: string): number {
  const tIndexMap = new Map<string, number>();

  for (let i = 0; i < t.length; i++) {
    tIndexMap.set(t[i], i);
  }

  let totalDifference = 0;

  for (let i = 0; i < s.length; i++) {
    const c = s[i];
    const indexInT = tIndexMap.get(c);

    if (indexInT !== undefined) {
      totalDifference += Math.abs(i - indexInT);
    }
  }

  return totalDifference;
}
