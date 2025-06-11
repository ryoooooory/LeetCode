/*
 * ・概要
 * 自力解法
 * 解法は全探索、DPすぐに思い浮かんだ。5分ほどでAC
 * DP解法としては、あるindexの要素に着目したとき、利益はそれまでの最低の価格で買った時との差分であるので、最低値のみを保持して毎回現在との差分を取れば良い。
 * これは１回の配列走査でおわるのでO(n)となり、変数だけもっておけばいいので空間もO(1)
 *
 * ・計算量
 * O(n)：nは配列の要素数
 * O(1)
 *
 * ・その他
 * せっかくなのであとで、全探索versionもかく。
 * ループは0でなく1からで良さそう。
 */

public class solution1_1 {
  public int maxProfit(int[] prices) {
    if (prices.length == 0 || prices.length == 1) {
      return 0;
    }
    int maxProfit = 0;
    int minPriceBefore = prices[0];
    for (int i = 0; i < prices.length; i++) {
      int currentMaxProfit = Math.max(0, prices[i] - minPriceBefore);
      maxProfit = Math.max(maxProfit, currentMaxProfit);
      if (prices[i] < minPriceBefore) {
        minPriceBefore = prices[i];
      }
    }
    return maxProfit;
  }
}
