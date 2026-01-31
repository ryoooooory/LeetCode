/*
・概要
他の人のMRを参考にした。
https://github.com/shintaro1993/arai60/pull/56/files
この問題をパッとみて木構造と連想できるのすごい。自分は全く浮かばなかった。
毎回繰り返し処理での実装をみるたびにpythonは簡単にかけるなあと思う。

https://github.com/fhiyo/leetcode/pull/52/files
先にソートして途中で処理中断できるので少し効率的
backTrackingで現在のindexの要素をいれてindexをかえないのと、いれないでindexふやすだけをやればいいので、solution1_1でも条件変えればできるじゃんと気づく。

*/

public class solution2_2 {
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
    combination.remove(combination.size() - 1);
    getCombination(candidates, target, combination, allCombination, index + 1, sum);
  }
}
