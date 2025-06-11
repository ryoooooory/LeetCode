/*
 * ・概要
 * 自力解法
 * 5分ほどでAC
 * 前問のHouse Robberと同様の解法が使えそうだなと思った。
 * サークル上なので問題となるのは最初のindexに注目すると最初の要素をとれば最後の要素がとれない、最初の要素をとらなければ最後の要素が取れる。
 * なので最初の要素を取ったときの場合のdpと最初の要素取らなかったときのdpを比べて大きい方が答えとなる。
 * dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
 *
 *
 * ・計算量
 * O(n): nは要素数
 * O(n):
 *
 * ・その他
 * House Robberと同様に１つ前の値と２つ前の値しか使わないので、配列は不要で変数でカバーできるので空間はO(1)にできそう
 * 最初の要素を取らないときのindexの動きが１つずれるのでちょっとわかりにくい？
 */

public class solution1_1 {
  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    } else if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    int[] maxSumWhenRobFirst = new int[nums.length - 1];
    maxSumWhenRobFirst[0] = nums[0];
    maxSumWhenRobFirst[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length - 1; i++) {
      maxSumWhenRobFirst[i] =
          Math.max(maxSumWhenRobFirst[i - 1], maxSumWhenRobFirst[i - 2] + nums[i]);
    }
    int[] maxSumWhenNotRobFirst = new int[nums.length - 1];
    maxSumWhenNotRobFirst[0] = nums[1];
    maxSumWhenNotRobFirst[1] = Math.max(nums[1], nums[2]);
    for (int i = 2; i < nums.length - 1; i++) {
      maxSumWhenNotRobFirst[i] =
          Math.max(maxSumWhenNotRobFirst[i - 1], maxSumWhenNotRobFirst[i - 2] + nums[i + 1]);
    }
    return Math.max(maxSumWhenRobFirst[nums.length - 2], maxSumWhenNotRobFirst[nums.length - 2]);
  }
}
