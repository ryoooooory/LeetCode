/*
・概要
自力解法。20分ほどでAC。１回Setを使わなかったので重複をゆるしたCombinationをだしてしまった。

・解き方
backtrackingで、以下をすすめていく。
1, 現在のindexのnumをいれてindex + 1いくケース
2, 現在のindexのnumをいれてindexそのままのケース
3, 現在のindexのnumをいれないでindex + 1いくケース

・計算量
多分。target / 最小の数 = 同じ数をどれだけ最大で使うかとなるので、
最小の数をM、targetをT, 要素数をNとして、
O(N^(T/M) * N) 　　＝最後の　* Nは配列入れる時のコピー

*/
public class solution1_1 {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Set<List<Integer>> allCombination = new HashSet<>();
    getCombination(candidates, target, new ArrayList<>(), allCombination, 0, 0);
    List<List<Integer>> allUniqueCombination = new ArrayList<>();
    for (List<Integer> combination : allCombination) {
      allUniqueCombination.add(combination);
    }
    return allUniqueCombination;
  }

  private void getCombination(
      int[] candidates,
      int target,
      List<Integer> combination,
      Set<List<Integer>> allCombination,
      int index,
      int sum) {
    if (target < sum || candidates.length <= index) {
      return;
    }
    if (target == sum) {
      allCombination.add(new ArrayList<>(combination));
      return;
    }
    combination.add(candidates[index]);
    getCombination(candidates, target, combination, allCombination, index, sum + candidates[index]);
    getCombination(
        candidates, target, combination, allCombination, index + 1, sum + candidates[index]);
    combination.remove(combination.size() - 1);
    getCombination(candidates, target, combination, allCombination, index + 1, sum);
  }
}
