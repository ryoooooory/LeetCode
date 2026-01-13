/*
・概要
https://github.com/olsen-blue/Arai60/pull/50
https://github.com/hroc135/leetcode/pull/46/files
などを参考に累積和で解いたもの

・考え方
累積和を作った後に、２つのポインタをつかってtarget以上となる範囲の最小を求めていくもの。
累積和については、prefixSum[0] = 0としたいので、1-indexedとする。

・計算量
O(n)

*/

public class solution2_2 {
  public int minSubArrayLen(int target, int[] nums) {
    int minLength = Integer.MAX_VALUE;
    int left = 0;
    int[] prefixSum = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      prefixSum[i + 1] = prefixSum[i] + nums[i];
    }
    for (int right = 1; right <= nums.length; right++) {
      while (left <= right && target <= prefixSum[right] - prefixSum[left]) {
        minLength = Math.min(minLength, right - left);
        left++;
      }
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }
}
