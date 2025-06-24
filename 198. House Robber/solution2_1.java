/*
 * 他の人の解法
 * https://github.com/Fuminiton/LeetCode/pull/35/files
 * だいたい同じ流れ
 * 読めば読むほどsolution1_1でdp
 * https://github.com/Fuminiton/LeetCode/pull/35/files#r2059511752
 * 確かに自分のもprevPrevは変えたいと思っていた
 *
 * おもに変数名の変更
 * https://github.com/olsen-blue/Arai60/pull/35/files
 * メモ化再帰でもできそうなのでやってみる
 */

public class solution2_1 {
  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    } else if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    int maxSumBeforeTwo = nums[0];
    int maxSumBeforeOne = Math.max(nums[0], nums[1]);
    int currentMaxSum = Math.max(maxSumBeforeOne, maxSumBeforeTwo);
    for (int i = 2; i < nums.length; i++) {
      currentMaxSum = Math.max(maxSumBeforeOne, maxSumBeforeTwo + nums[i]);
      maxSumBeforeTwo = maxSumBeforeOne;
      maxSumBeforeOne = currentMaxSum;
    }

    return currentMaxSum;
  }
}
