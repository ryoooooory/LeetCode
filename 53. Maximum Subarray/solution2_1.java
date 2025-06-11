/*
 * ・概要
 * 他の人の解法を参考にしてみた。
 *
 * https://github.com/olsen-blue/Arai60/blob/83c63771c88deceb3650205a337cb16219e4b05c/53.%20Maximum%20Subarray.md
 * https://github.com/Mike0121/LeetCode/blob/1f3ce3df357ad9478e214141797e987f015cbbb1/%E7%AB%B6%E6%8A%80%E3%83%97%E3%83%AD%E5%B0%B1%E6%B4%BB%E9%83%A8PR%E7%94%A8/53.%20Maximum%20Subarray.md
 * https://github.com/TORUS0818/leetcode/pull/34/files
 * 累積和を使う方針。確かに配列で区間を決めて和と聞いたら累積和が第一候補だよなと感じた。
 * 高低差でイメージするとわかりやすい。結局部分配列の最大は特定区間で一番高低差が大きく高くなったかということ。
 * なので、累積和を現在の高低差の積み上げと捉えると、その積み上げから最低の低さ（ある区間までの累積和）を引いてやると高低差がでる。
 *
 * ・計算量
 * 時間：O(n)
 * 空間：O(1)
 *
 *
 */

public class solution2_1 {
  public int maxSubArray(int[] nums) {
    int prefixSum = 0;
    int minPrefixSum = 0;
    int maxSubArraySum = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      prefixSum += nums[i];
      maxSubArraySum = Math.max(maxSubArraySum, prefixSum - minPrefixSum);
      minPrefixSum = Math.min(minPrefixSum, prefixSum);
    }
    return maxSubArraySum;
  }
}
