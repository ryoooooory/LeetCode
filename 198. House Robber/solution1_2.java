/*
 * ・概要
 * 自力解法
 * solution1_1の配列使わないバージョン
 *
 *
 * ・計算量
 * O(n): nはnumsの要素数
 * O(1)
 *
 */

public class solution1_2 {
  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    } else if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    int prevPrevMaxSum = nums[0];
    int prevMaxSum = Math.max(nums[0], nums[1]);
    int currentMaxSum = prevMaxSum;
    for (int i = 2; i < nums.length; i++) {
      currentMaxSum = Math.max(prevMaxSum, prevPrevMaxSum + nums[i]);
      prevPrevMaxSum = prevMaxSum;
      prevMaxSum = currentMaxSum;
    }
    return currentMaxSum;
  }
}
