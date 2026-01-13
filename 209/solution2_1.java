/*
・概要
他の人のMRを見て参考にした
https://github.com/Satorien/LeetCode/pull/48/files
変数について、sumでなくsumNumsInWindowとかもあり
２重ループを使っていて、ループの中でまずsumに足すことは前提として、sumが超えた場合は、leftを更新しながらsumを減らす手法。
確かにこっちのが直感的かなとも思った。
https://github.com/Fuminiton/LeetCode/pull/51/files
left, rightをwindowStart, windowEndみたいにしている。たしかに明確だがleft, rightでもまあ伝わるんじゃないかなと個人的には思った。
これも２重ループ派
https://github.com/TORUS0818/leetcode/pull/51/files
やはり最小の長さを表す変数の初期値で議論がある。問題の制約上としてはnumsの要素数のMAXが10^5なのでIntの最大値でも特に問題はないと思う。
ただ、targetとsumの比較部分はあやしい。超えそうな場合はlongにキャストするなど対策を取る必要がありそう（numsの要素は10^4で、numsの要素数は10^5までいくので、sumは10^9になり、intの最大値を超える可能性があるので）

https://github.com/hroc135/leetcode/pull/46/files#r2030100029
これは自分も同意
*/

public class solution2_1 {
  public int minSubArrayLen(int target, int[] nums) {
    int minLength = Integer.MAX_VALUE;
    int left = 0;
    int windowSum = 0;
    for (int right = 0; right < nums.length; right++) {
      windowSum += nums[right];
      while (left <= right && target <= windowSum) {
        minLength = Math.min(minLength, right - left + 1);
        windowSum -= nums[left];
        left++;
      }
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }
}
