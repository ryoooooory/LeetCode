/*
・概要
backtracking

・所感
直感的なのはやはりsolution1_1かこちらの解法（繰り返しかbacktracking）かなと思った。

*/

public class solution1_3 {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> allSubsets = new ArrayList<>();
    makeSubsets(nums, allSubsets, 0, new ArrayList<>());
    return allSubsets;
  }

  private void makeSubsets(
      int[] nums, List<List<Integer>> allSubsets, int currentIndex, List<Integer> subset) {
    allSubsets.add(new ArrayList<>(subset));
    for (int index = currentIndex; index < nums.length; index++) {
      subset.add(nums[index]);
      makeSubsets(nums, allSubsets, index + 1, subset);
      subset.remove(subset.size() - 1);
    }
  }
}
