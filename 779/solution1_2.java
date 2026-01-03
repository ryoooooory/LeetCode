/*
・概要
solution1_1を元にchatgptにリファクタリングの提案をしてもらったもの。

・詳細
特定の値xより小さい最大の2の累乗については、javaですでに関数が用意されていた。Integer.highestOneBit　（最上位Bitを１にしてあとを0にする）
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Integer.html#highestOneBit-int-


*/
public class solution1_2 {
  public int kthGrammar(int n, int k) {
    boolean flipped = false;
    int currentTarget = k;
    while (currentTarget != 1) {
      int highestPowerOfTwo = Integer.highestOneBit(currentTarget - 1);
      currentTarget = currentTarget - highestPowerOfTwo;
      flipped = !flipped;
    }
    return flipped ? 1 : 0;
  }
}
