/*
 * ・概要
 * 自力解法
 * solution1_1のメモリ効率化のために、配列から変数にした。
 *
 * ・計算量
 * O(n): nは要素数
 * O(1)
 *
 * ・その他
 * House Robberと同様に１つ前の値と２つ前の値しか使わないので、配列は不要で変数２つでカバーできるので空間はO(1)にできそう
 * 最初の要素を取らないときのindexの動きが１つずれるのでちょっとわかりにくい？
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
    int maxSumRobFirstTwoBefore = nums[0];
    int maxSumRobFirstOneBefore = Math.max(nums[0], nums[1]);
    int currentMaxSumRobFirst = Math.max(maxSumRobFirstOneBefore, maxSumRobFirstTwoBefore);
    for (int i = 2; i < nums.length - 1; i++) {
      currentMaxSumRobFirst = Math.max(maxSumRobFirstOneBefore, maxSumRobFirstTwoBefore + nums[i]);
      maxSumRobFirstTwoBefore = maxSumRobFirstOneBefore;
      maxSumRobFirstOneBefore = currentMaxSumRobFirst;
    }
    int maxSumNotRobFirstTwoBefore = nums[1];
    int maxSumNotRobFirstOneBefore = Math.max(nums[1], nums[2]);
    int currentNotMaxSumRobFirst = Math.max(maxSumNotRobFirstOneBefore, maxSumNotRobFirstTwoBefore);
    for (int i = 2; i < nums.length - 1; i++) {
      currentNotMaxSumRobFirst =
          Math.max(maxSumNotRobFirstOneBefore, maxSumNotRobFirstTwoBefore + nums[i + 1]);
      maxSumNotRobFirstTwoBefore = maxSumNotRobFirstOneBefore;
      maxSumNotRobFirstOneBefore = currentNotMaxSumRobFirst;
    }
    return Math.max(currentMaxSumRobFirst, currentNotMaxSumRobFirst);
  }
}
