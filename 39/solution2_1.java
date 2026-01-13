/*
・概要
LeetCodeの解法

・解き方
backtrackingだが、solution1_1と違って、Setを使わない。
これは再帰処理の中で渡されたindex以上の要素について足して渡していくことで結果的に重複が生まれない。
solution1_1でもindexをずらす処理があるのに重複が出てしまったのは、現在の値をsumにいれて、indexを増やすケースとindexをそのままで渡すケースにおいて、結果的に同じcombinationでindexだけ違うけどsumが同じ状態が発生したことが原因。

*/

public class solution2_1 {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> allCombination = new ArrayList<>();
    getCombination(candidates, target, new ArrayList<>(), allCombination, 0, 0);
    return allCombination;
  }

  private void getCombination(
      int[] candidates,
      int target,
      List<Integer> combination,
      List<List<Integer>> allCombination,
      int start,
      int sum) {
    if (target < sum || candidates.length <= start) {
      return;
    }
    if (target == sum) {
      allCombination.add(new ArrayList<>(combination));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      combination.add(candidates[i]);
      getCombination(candidates, target, combination, allCombination, i, sum + candidates[i]);
      combination.remove(combination.size() - 1);
    }
  }
}
