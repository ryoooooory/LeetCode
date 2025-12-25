/*
・概要
他の人の解法を参考にしたもの
https://github.com/nanae772/leetcode-arai60/pull/37/files
こちらのコメントでindex = 0の要素について、２回無駄にチェックしてるねというコメントがあって自分にもあてはまったのでそちらを改善してみる。
変数名について、前後のコンテキストを入れたいときは、yesterday, todayのようにした方が良いかもと思った。

*/

public class solution2_2 {
  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int buyPrice = prices[0];
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (buyPrice < prices[i]) {
        profit += prices[i] - buyPrice;
      }
      buyPrice = prices[i];
    }
    return profit;
  }
}
