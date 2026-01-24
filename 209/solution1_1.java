/*
・概要
自力解法。
解放自体はすぐ思いついたが、繰り返し処理のところで、うまく頭を整理できず15分くらいかかった。

・解法
3. Longest Substring Without Repeating Characters と同様にslidingwindowの問題。
先行で走査するrightにあわせてsumをふやしていき、targetをこえたらleftをインクリメントしながら長さを更新していく。

・計算量
時間:O(n) n:numsの要素数
空間:O(1)

*/

public class solution1_1 {
  public int minSubArrayLen(int target, int[] nums) {
    int minLength = Integer.MAX_VALUE; // booleanでも可能
    int left = 0;
    int right = 0;
    int sum = 0;
    while (right < nums.length) {
      if (target <= sum + nums[right]) {
        minLength = Math.min(minLength, right - left + 1);
        sum -= nums[left];
        left++;
        continue;
      }
      sum += nums[right];
      right++;
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }
}
