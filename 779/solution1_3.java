/*
・概要
solution1_1を元にchatgptにリファクタリングの提案をしてもらったもの。
solution1_2と違い、ライブラリ関数を使わない実装

・solution1_1からの改善点
リネーム
xより小さい2の累乗をさがす関数について不要な条件をなくした。
*/

public class solution1_3 {
  public int kthGrammar(int n, int k) {
    boolean flipped = false;
    int currentTarget = k;
    while (currentTarget != 1) {
      int highestPowerOfTwo = highestPowerOfTwoBelow(currentTarget);
      currentTarget = currentTarget - highestPowerOfTwo;
      flipped = !flipped;
    }
    return flipped ? 1 : 0;
  }

  private int highestPowerOfTwoBelow(int target) {
    int result = 1;
    while (result * 2 < target) {
      result *= 2;
    }
    return result;
  }
}
