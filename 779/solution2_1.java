/*
・概要
他の人の解法などを参考にしたもの
https://github.com/garunitule/coding_practice/pull/46/files
確かにn < kのバリデーションは普通すべき。似た考え方でbit反転して再帰している。自分の実装と似ているがnを使って、対象のindexがどこにあるかを見ていくスタイル。たしかにnがあるのに自分の実装ではつかってなかったな〜とおもった。

*/

public class solution2_1 {
  public int kthGrammar(int n, int k) {
    int flippedCount = 0;
    int targetPosition = k;
    int currentRowLength = (int) Math.pow(2, (n - 1));
    while (1 < currentRowLength) {
      if ((currentRowLength / 2) < targetPosition) {
        targetPosition -= (currentRowLength / 2);
        flippedCount++;
      }
      currentRowLength = currentRowLength / 2;
    }
    return (flippedCount % 2) == 1 ? 1 : 0;
  }
}
