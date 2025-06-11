/*
 * ・概要
 * 自力解法
 * solution1_2でTime Limit Exceededなのでそもそもの考え方から練り直した。
 * よくよく考えると、i番目までの最大の部分和を考えるときにi-1番目までの最大にi番目までの要素を加えたとき or i番目のみ　の大きい方となるので、その２通りを保持していけばいい。
 * そうなると、i-1番目までの最大部分和だけを保持しておけばいいので、配列もいらない。
 *
 *
 * ・計算量
 * 時間：O(n)
 * 空間：O(1)
 *
 * ・所感
 * 漸化式が一度わかるとどんどん改善できるが、初手にこの漸化式を思いつくのに時間がかかる。もっと単純に考えるべき？
 */

public class solution1_3 {
  public int maxSubArray(int[] nums) {
    int prevMaxSubArraySum = nums[0];
    int maxSubArraySum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      prevMaxSubArraySum = Math.max(prevMaxSubArraySum, nums[i - 1]) + nums[i];
      maxSubArraySum = Math.max(maxSubArraySum, Math.max(prevMaxSubArraySum, nums[i]));
    }
    return maxSubArraySum;
  }
}
