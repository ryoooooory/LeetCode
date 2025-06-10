/*
 * ・概要
 * 自力解法
 * 全探索バージョン、二重ループ
 * DP解法としては、あるindexの要素に着目したとき、利益はそれまでの最低の価格で買った時との差分であるので、最低値のみを保持して毎回現在との差分を取れば良い。
 * これは１回の配列走査でおわるのでO(n)となり、変数だけもっておけばいいので空間もO(1)
 *
 * ・計算量
 * O(n^2)：今回は最大でn=10^5となるので、最大10Gかかる。Macだとクロック数が数GHzなので、単純計算でも3sくらいはかかる。
 * Javaのオーバーヘッドを加味して、だいたい３倍くらいかかる（10sくらい）という予想
 * 以前共有いただいたJavaとかのベンチマーク
 * https://benchmarksgame-team.pages.debian.net/benchmarksgame/box-plot-summary-charts.html
 * https://github.com/niklas-heer/speed-comparison
 *
 * O(1)
 *
 * ・その他
 * せっかくなのであとで、全探索versionもかく。
 * ループは0でなく1からで良さそう。
 */

public class solution1_2 {
  public int maxProfit(int[] prices) {
    if (prices.length == 0 || prices.length == 1) {
      return 0;
    }
    int maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      for (int j = 0; j < i; j++) {
        maxProfit = Math.max(maxProfit, prices[i] - prices[j]);
      }
    }
    return maxProfit;
  }
}
