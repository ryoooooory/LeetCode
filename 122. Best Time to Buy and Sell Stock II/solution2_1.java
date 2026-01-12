/*
* https://github.com/ryoooooory/LeetCode/pull/40/files
* 他の人の解法を参考にしたもの。
* 毎日株価をみて、前日との比較をすることで更新する方法。更新日数に制限がないのでこの方法で良く制限があるときはsolution1のような方法が必要になると認識した。
* 上記のPRにもあるが、前日との比較なのでそもそもbuyPriceなくても成立する。
* ・計算量
* 　時間計算量：O(n) n: pricesの要素数
* 　空間計算量：O(1)

*/

public class solution2_1 {
  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int buyPrice = prices[0];
    int profit = 0;
    for (int price : prices) {
      if (buyPrice < price) {
        profit += price - buyPrice;
      }
      buyPrice = price;
    }
    return profit;
  }
}
