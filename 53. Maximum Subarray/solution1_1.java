/*
 * ・概要
 * 自力解法
 * DPを思いつき、dp[i][j]を 左端j, 右端i番目のときの和とすることで二重ループで各部分和を求めるという流れ。
 * 問題制約からわかっていたが予想通りMemory Limit Exceededとなった。
 *
 * ・計算量
 * 時間：O(n^2)
 * 空間：O(n^2)　10^5なので、配列の大きさはヒープメモリの大きさによるが、数GBらしいのでめちゃ多く見積もっても1GBくらいしかつめない。（ちなみに１次元配列ではintの最大値がMAX：実際じゃVMによって異なるらしい）
 * 今回の場合は二次元なので今回は10GBまでいくのでOUT
 * LeetCode上で試してみると、50MBくらいでOUTになる。→これはLeetCodeの環境のせいだろうか
 */

public class solution1_1 {
  public int maxSubArray(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int length = nums.length;
    int[][] sumArraySum = new int[length][length];
    int maxSubArraySum = nums[0];
    for (int i = 0; i < length; i++) {
      for (int j = 0; j <= i; j++) {
        if (i == 0) {
          sumArraySum[i][j] = nums[i];
        } else {
          sumArraySum[i][j] = sumArraySum[i - 1][j] + nums[i];
        }
        maxSubArraySum = Math.max(maxSubArraySum, sumArraySum[i][j]);
      }
    }
    return maxSubArraySum;
  }
}
