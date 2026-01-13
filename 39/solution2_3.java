/*
・概要
他の人のMRを参考にした。
DP
https://github.com/fhiyo/leetcode/pull/52#issuecomment-2248269934
*/

public class solution2_3 {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>>[] allCombination = new ArrayList[target + 1];
    for (int i = 0; i <= target; i++) {
      allCombination[i] = new ArrayList<>();
    }
    allCombination[0].add(new ArrayList<>());
    for (int candidate : candidates) {
      if (target < candidate) {
        continue;
      }
      List<Integer> combinationWithCandidate = new ArrayList<>();
      combinationWithCandidate.add(candidate);
      allCombination[candidate].add(combinationWithCandidate);
      for (int num = candidate + 1; num <= target; num++) {
        for (List<Integer> combination : allCombination[num - candidate]) {
          List<Integer> nextCombination = new ArrayList<>(combination);
          nextCombination.add(candidate);
          allCombination[num].add(nextCombination);
        }
      }
    }
    return allCombination[target];
  }
}
