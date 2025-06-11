/*・概要
 * 他の人の解法を参考。
 * https://github.com/irohafternoon/LeetCode/pull/39/files
 * メモ化再帰での解法
 *
 * ・その他
 * https://discord.com/channels/1084280443945353267/1206101582861697046/1229120056248766627
 * オプションとして、キャッシュなしでもO(n)できるらしい、オプションとして確認
 */

public class solution2_2 {
  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    } else if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    int[] memo = new int[nums.length];
    Arrays.fill(memo, -1);
    int maxSumForWhenRobFirst = robHelper(nums, memo, 0, nums.length - 2);
    Arrays.fill(memo, -1);
    int maxSumForWhenNotRobFirst = robHelper(nums, memo, 1, nums.length - 1);
    return Math.max(maxSumForWhenRobFirst, maxSumForWhenNotRobFirst);
  }

  private int robHelper(int[] nums, int[] memo, int endIndex, int currentIndex) {
    if (currentIndex < endIndex) {
      return 0;
    }
    if (currentIndex == endIndex) {
      return nums[currentIndex];
    }
    if (memo[currentIndex] != -1) {
      return memo[currentIndex];
    }
    memo[currentIndex] =
        Math.max(
            robHelper(nums, memo, endIndex, currentIndex - 1),
            robHelper(nums, memo, endIndex, currentIndex - 2) + nums[currentIndex]);
    return memo[currentIndex];
  }
}
