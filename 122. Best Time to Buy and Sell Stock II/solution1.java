/*
 * ・概要
 * 　自力解法。解法はテクニックというより、頭の中でシミュレーションして考えた感じ。15分くらいかかった。
 * 　株価が上がり続ける限りはホールドし、下がり始めたら売る、を繰り返す。
 * 　最後に残った分も売る。
 * ・計算量
 * 　時間計算量：O(n) n: pricesの要素数
 * 　空間計算量：O(1)
 *
 * ・所感
 * 　解法の思いつきはそこまで時間が掛からなかったが、初期条件と更新する変数の扱いで少し悩んだ。
 *   結局updatedというフラグを用意して、最大値が更新されたかどうかを管理することで解決したが、もう少しスマートな方法があるかもしれない。
 * ちなみに株価が上がり続ける限りはホールドし、下がり始めたら売る→アップトレンドというらしい
 *
 * ・追記
 * 他の人が実行時間の見積もり出していたので同じように出してみる。
 * https://github.com/5103246/LeetCode_Arai60/pull/36/files
 *
 * 配列の最大数が3*10^4
 * クロック周波数は最近のCPUで3,4GHzくらいらしいので、1秒間に30億クロック。１命令は４クロックくらいかかるらしいので、1秒間に10^8回くらいにおちつく。さらにJavaはC++に比べて遅いらしいので、1秒間に10^7回くらいと見積もる。
 * https://github.com/niklas-heer/speed-comparison
 * よって、3*10^4回のループは3*10^4/10^7 = 0.003秒(3ms)くらいと見積もれる。
 *
 * ・その他
 * https://github.com/t9a-dev/LeetCode_arai60/pull/38/files
 * 解法としては上記とほぼ一緒
 */

public class solution1 {
  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int currentMax = prices[0];
    int currentStockPrice = prices[0];
    boolean updated = false; // ちょっと抽象的でわかりにくい変数かも
    int currentProfit = 0; // currentはなくてもいいかも
    for (int price : prices) {
      if (currentMax < price) {
        currentMax = price;
        updated = true;
      } else if (price < currentMax) {
        if (updated) {
          currentProfit += currentMax - currentStockPrice;
        }
        currentStockPrice = price;
        currentMax = price;
        updated = false;
      }
    }
    currentProfit += currentMax - currentStockPrice;
    return currentProfit;
  }
}
