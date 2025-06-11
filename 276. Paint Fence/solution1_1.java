/*
 * ・概要
 * 初回解法。DPを使うことや漸化式を考えている途中で時間がかかったのでLeetCodeの解法を参考にした。
 * 自力で考えている時は、1,2の状態は決まるが3つめから前の状態を使って導くことには気づいたが式の導出まではできなかった。
 * 解法としては、３つめ以降にi番目のフェンスのペイントをぬることを考える。
 * i-1番目と違う色を塗る場合を考えると、各フェンスについて(k-1)通りあるので、(k-1)*sum(i-1)
 * i番目と同じ色を塗る場合を考えると、問題ルールによって2つ前と1つ前が違う色で塗られている必要があり、これは(k-1)*sum(i-2)となる。
 * よって、合計はsum(i) = (k-1)*sum(i-1)+(k-1)*sum(i-2)
 *
 * DP的に配列などを作っても良かったが、漸化式に着目するとi-1の合計値とi-2の合計値だけもってればいいので、メモリ使用量を減らすために変数で対応した。
 *
 * ・計算量
 * 時間計算量：O(n)
 * 空間計算量：O(1)
 *
 * ・その他
 * 変数名の付け方が微妙（とくにprevPreCountOfPatterns）、あとcurrentCountOfPatternsが若干いらない感じになっているのも気になる。
 *
 */

public class solution1_1 {
  public int numWays(int n, int k) {
    if (n == 1) {
      return k;
    }
    if (n == 2) {
      return k * k;
    }
    int prevPreCountOfPatterns = k;
    int prevCountOfPatterns = k * k;
    int currentCountOfPatterns = 0;
    for (int i = 3; i <= n; i++) {
      currentCountOfPatterns = (k - 1) * (prevPreCountOfPatterns + prevCountOfPatterns);
      prevPreCountOfPatterns = prevCountOfPatterns;
      prevCountOfPatterns = currentCountOfPatterns;
    }
    return currentCountOfPatterns;
  }
}
