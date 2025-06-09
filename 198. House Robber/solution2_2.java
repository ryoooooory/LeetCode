/*
 * https://github.com/olsen-blue/Arai60/pull/35/files
 * メモ化再帰でもできそうなのでやってみる
 * 考え方としては、1つ前と2つ前の最大値+現在の値のおおきいほうをとっていくも
 * 上記では再帰の基底状態のindex == 1をやることで、memo[0]を最初に定義しなくてもよくしている。
 *
 * ・計算量
 * O(n): nはnumsの要素数
 * O(n)
 *
 *
 */

public class solution2_2 {
  public int rob(int[] nums) {
    int[] memo = new int[nums.length];
    Arrays.fill(memo, -1);
    memo[0] = nums[0];
    robHelper(nums, memo, nums.length - 1);
    int maxSum = 0;
    for (int i = 0; i < nums.length; i++) {
      maxSum = Math.max(maxSum, memo[i]);
    }
    return maxSum;
  }

  private int robHelper(int[] nums, int[] memo, int currentIndex) {
    if (currentIndex < 0) {
      return 0;
    }
    if (currentIndex == 0) {
      return memo[0];
    }
    if (memo[currentIndex] != -1) {
      return memo[currentIndex];
    }
    memo[currentIndex] =
        Math.max(
            robHelper(nums, memo, currentIndex - 2) + nums[currentIndex],
            robHelper(nums, memo, currentIndex - 1));
    return memo[currentIndex];
  }
}
