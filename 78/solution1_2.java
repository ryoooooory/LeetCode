/*
全列挙しながら降りていくver

*/

public class solution1_2 {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> allSubsets = new ArrayList<>();
    allSubsets.add(new ArrayList<>());
    makeSubsets(nums, allSubsets, 0);
    return allSubsets;
  }

  private void makeSubsets(int[] nums, List<List<Integer>> allSubsets, int index) {
    if (nums.length <= index) {
      return;
    }
    List<List<Integer>> tempSubsets = new ArrayList<>();
    for (List<Integer> subset : allSubsets) {
      List<Integer> tempSubset = new ArrayList<>(subset);
      tempSubset.add(nums[index]);
      tempSubsets.add(tempSubset);
    }
    allSubsets.addAll(tempSubsets);
    makeSubsets(nums, allSubsets, index + 1);
  }
}
