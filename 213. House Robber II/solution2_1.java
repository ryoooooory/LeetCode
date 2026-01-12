/*
 * ・概要
 * 他の人の解法を参考。
 *
 * https://github.com/irohafternoon/LeetCode/pull/39/files
 * 確かに２回走査しているところはちがうところが始点と終点だけなので関数化するのがいい。今回は答えしかいらないのでこれが良さそう。
 * https://github.com/hroc135/leetcode/pull/34/files
 * helper関数についてリネーム。
 *
 * ・計算量
 * 時間：O(n)
 * 空間：O(n), 今回はnは最大で100で、スタックフレームもせいぜい数10Byteくらいなので、Maxでも1kByteくらい。
 * JVMのデフォルトのスタックサイズは1Mくらいなので問題ない。
 *
 */
public class solution2_1 {
  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    } else if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    return Math.max(robInLine(nums, 0, nums.length - 2), robInLine(nums, 1, nums.length - 1));
  }

  private int robInLine(int[] nums, int startIndex, int endIndex) {
    int maxSumTwoBefore = nums[startIndex];
    int maxSumOneBefore = Math.max(nums[startIndex], nums[startIndex + 1]);
    int currentMaxSum = Math.max(maxSumOneBefore, maxSumTwoBefore);
    for (int i = startIndex + 2; i <= endIndex; i++) {
      currentMaxSum = Math.max(maxSumOneBefore, maxSumTwoBefore + nums[i]);
      maxSumTwoBefore = maxSumOneBefore;
      maxSumOneBefore = currentMaxSum;
    }
    return currentMaxSum;
  }
}
