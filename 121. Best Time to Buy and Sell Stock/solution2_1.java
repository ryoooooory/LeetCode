/*
* https://github.com/irohafternoon/LeetCode/pull/40/files
* たしかにif文で分岐させると意味合い的にもわけられていいかも
*
* https://github.com/huyfififi/coding-challenges/pull/4/files
* たしかに後ろからみていくのも悪くない。直感的なのは左からみていくだが、（未来 - 過去）という構図がわかりやすいなと思った。
*
* https://github.com/seal-azarashi/leetcode/pull/35/files
* 大体同じ
*
*
* 以下では後ろからみていく実装を行う。
*
* ・計算量
* time: O(n), space: O(1)

* ・その他
* maxPriceInFutureはやりすぎかも、maxPriceだけでも十分伝わりそう
*
* https://github.com/colorbox/leetcode/pull/6/files
* https://github.com/goto-untrapped/Arai60/pull/58/files#r1782742318
* 関数型的考え、scanlを調べたところ、累積結果をすべて返す関数らしく、scanl (+) 0 [1, 2, 3, 4] -- => [0, 1, 3, 6, 10], この例だと累積和だ
* ということで最小値と最大値を累積していき、最後にその結果の配列を元にprofitをみていくことだと解釈した。

*/

public class solution2_1 {
  public int maxProfit(int[] prices) {
    if (prices.length == 0 || prices.length == 1) {
      return 0;
    }
    int maxProfit = 0;
    int maxPriceInFuture = prices[prices.length - 1];
    for (int i = prices.length - 2; i >= 0; i--) {
      if (maxPriceInFuture < prices[i]) {
        maxPriceInFuture = prices[i];
        continue;
      }
      maxProfit = Math.max(maxProfit, maxPriceInFuture - prices[i]);
    }
    return maxProfit;
  }
}
