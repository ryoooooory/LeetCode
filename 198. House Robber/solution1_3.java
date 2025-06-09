/*
 * ・概要
 * 自力解法
 * solution1_1でコメントにも書いた、より直感的な動的計画法バージョン
 * dp[i][j]: j=0のときは、i番目をつかうときの最大合計数、j=1のときは、i番目を使わないときの最大合計数
 * dp[i][0] = dp[i-1][1] + nums[i] : i-1は使えないので
 * dp[i][1] = Max(dp[i - 1][0], dp[i - 1][1]) : iは使わないので、i-1番目までの最大をとる
 * 個人的にはこっちのが素直
 * 例：[1,2,4,3]の場合、i = 0:[[1,0]] i = 1:[[1,0],[2,1]], i = 2:[[1,0], [2,1], [4,2]], i = 3:[[1,0], [2,1], [4,2], [3,4]]
 * ここまできて、あっdp[i][1]ってdp[i-1][0]と同じやん！じゃあ１次元配列に省略できるね
 * dp[i] = max(dp[i - 1], dp[i - 2] + nums[i]) : solution1_1の解法だ！！！！！！！
 *
 * ・計算量
 * O(n): nはnumsの要素数
 * O(n)
 *
 */

public class solution1_3 {
  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int[][] currentMaxSum = new int[nums.length][2];
    currentMaxSum[0][0] = nums[0];
    currentMaxSum[0][1] = 0;
    int maxSum = Math.max(currentMaxSum[0][0], currentMaxSum[0][1]);
    for (int i = 1; i < nums.length; i++) {
      currentMaxSum[i][0] = currentMaxSum[i - 1][1] + nums[i];
      currentMaxSum[i][1] = Math.max(currentMaxSum[i - 1][0], currentMaxSum[i - 1][1]);
      maxSum = Math.max(maxSum, Math.max(currentMaxSum[i][0], currentMaxSum[i][1]));
    }
    return maxSum;
  }
}
