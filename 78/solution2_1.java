/*
・他の人の解法を参考にしたもの
https://github.com/shintaro1993/arai60/pull/55/files
ある数字をいれるかいれないかということを繰り返すイメージ。solution1系と違っていれるいれないを主眼においていてなるほどなと思った。
計算量もシンプルに考えられて、全通りで2^n,　配列の作成にnかからるので、O(n*2^n)
https://github.com/shintaro1993/arai60/pull/55/files#r2478376870
変数名もたしかにnewSubsetよりsubsetWithNumのがわかりやすい


https://github.com/Fuminiton/LeetCode/pull/53/files
こちらは上と同じような考えだが、boolean配列でつかうつかわないを記録していき、最後にListつくっていれていくもの。
いろいろ考え方あるなと思った。

https://github.com/fuga-98/arai60/pull/50/files
この辺も同じ。

・解法
ある数字をいれるかいれないかということを繰り返す

*/

public class solution2_1 {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> allSubset = new ArrayList<>();
    makeSubsets(nums, allSubset, new ArrayList<>(), 0);
    return allSubset;
  }

  private void makeSubsets(
      int[] nums, List<List<Integer>> allSubset, List<Integer> subset, int index) {
    if (nums.length <= index) {
      allSubset.add(new ArrayList<>(subset));
      return;
    }
    List<Integer> subsetWithNum = new ArrayList<>(subset);
    subsetWithNum.add(nums[index]);
    makeSubsets(nums, allSubset, subsetWithNum, index + 1);
    makeSubsets(nums, allSubset, subset, index + 1);
  }

  // backTracking verも書いてみた。
  private void makeSubsets(
      int[] nums, List<List<Integer>> allSubset, List<Integer> subset, int index) {
    if (nums.length <= index) {
      allSubset.add(new ArrayList<>(subset));
      return;
    }
    allSubset.add(nums[index]);
    makeSubsets(nums, allSubset, subset, index + 1);
    allSubset.remove(allSubset.size - 1);
    makeSubsets(nums, allSubset, subset, index + 1);
  }
}
