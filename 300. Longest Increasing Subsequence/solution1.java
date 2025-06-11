/*
 * ・概要
 * 初回解法。漸化式を考えている途中で時間がかかったのでLeetCodeの解法を参考にした。
 * 解法としては、現在のindexでの最大増加部分配列をする。これをf(i)とし、i番目の要素をnums(i)すると、f(i)はiまでのindexでの部分配列の中でnums(j)<nums(i)を満たす中での最大値+1となる。
 * よって、f(i) = max f(j) + 1
 *
 * ・計算量
 * 時間計算量：O(n^2) :nはnumsの要素数
 * 空間計算量：O(n)
 *
 * ・その他
 * 変数名が長すぎるかもしれない。変数名をりゃ
 *
 */

public class solution1 {
  public int lengthOfLIS(int[] nums) {
    int[] lengthOfIncreasingSubsequence = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      lengthOfIncreasingSubsequence[i] = 1;
    }
    int lengthOfLongestIncreasingSubsequence = 1;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          lengthOfIncreasingSubsequence[i] =
              Math.max(lengthOfIncreasingSubsequence[j] + 1, lengthOfIncreasingSubsequence[i]);
        }
        lengthOfLongestIncreasingSubsequence =
            Math.max(longestLengthOfIncreasingSubsequence, lengthOfIncreasingSubsequence[i]);
      }
    }
    return lengthOfLongestIncreasingSubsequence;
  }
}
