/*
 *
 * https://github.com/ryoooooory/LeetCode/pull/33#discussion_r2132537855
 * メモ化再帰で実装
 *
 * ・計算量
 * O(n)
 * O(n)
 */

public class solution3_1 {
  public int numWays(int n, int k) {
    if (n == 0) {
      return 0;
    }
    return numWaysHelper(n, k, new int[n + 1]);
  }

  private int numWaysHelper(int n, int k, int[] memo) {
    if (n == 1) {
      return k;
    } else if (n == 2) {
      return k * k;
    }
    if (memo[n] != 0) {
      return memo[n];
    }
    memo[n] = (k - 1) * (numWaysHelper(n - 1, k, memo) + numWaysHelper(n - 2, k, memo));
    return memo[n];
  }
}
