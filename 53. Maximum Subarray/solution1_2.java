/*
 * ・概要
 * 自力解法
 * solution1_1でMemory Limit Exceededなので一次元にできないかを考えた。
 * よくよく考えると、１つ前の結果しか使わないので二次元に必要がないことがわかり、１次元配列にした。
 * 問題制約から予想通りTime Limit Exceededとなった。
 *
 * ・計算量
 * 時間：O(n^2) 10^5なので、最大10^10の処理がかかってしまう。クロック周波数が一般的なPCは数GHzくらいの認識なので、およそ数秒~おそくても10秒くらいかかる認識。
 * 空間：O(n)
 */

public class solution1_2 {
  public int maxSubArray(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int length = nums.length;
    int[] sumArraySum = new int[length];
    int maxSubArraySum = nums[0];
    for (int i = 0; i < length; i++) {
      for (int j = 0; j <= i; j++) {
        if (i == 0) {
          sumArraySum[j] = nums[i];
        } else {
          sumArraySum[j] = sumArraySum[j] + nums[i];
        }
        maxSubArraySum = Math.max(maxSubArraySum, sumArraySum[j]);
      }
    }
    return maxSubArraySum;
  }
}
