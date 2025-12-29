/*
・概要
solution2_2のDPバージョン。
https://github.com/5103246/LeetCode_Arai60/pull/37/files#diff-d47cadfa666e888fa6f7733f5a1ef36445b694f3145516369f324fbbd15c6ef6R46を参考にした。
思考の流れとしては、文字SがDictにあるもので構成できるとき、あるindexから始まる部分文字列とそのindexまでの部分文字列についても両方Dictにあるもので構成できることと同じである。
そのため、indexを変数として持ち、そこまでの部分文字列とそのIndexからの文字列についてDictにあるもので構成できるかを考える。
なのでDP的に考えると
DP[i] = sのi番目の文字から最後までの部分文字列がDictにあるもので構成できるか
となる。式とすると
DP[i] = i番前までの部分文字列がDictにあるもので構成できるか
      = i番前までの部分文字列がDictにあるもので前方一致するか && i + Dictで一致した単語の文字列長さから最後までの部分文字列がDictにあるもので構成できるか
      = 番前までの部分文字列がDictにあるもので前方一致するか && DP[i + Dictで一致した単語の文字列長さ]
となる。
ということで、文字列について後ろの文字からみていくことで、DP配列を埋めていく。


・計算量
時間計算量：O(n^2 * m) n: sの長さ, m: wordDictの単語数
空間計算量：O(n)

・所感
メモ化とDPどちらも解法をおもいつくのに、やはり最初に基底状態をイメージすることが大事だと思った。
基本的にはある時点の状態と次（or 前）の状態との関係性を考える。状態の定義ができれば基底状態を考える。
そのあとトップダウンなら再帰、ボトムアップならループで実装する。

*/

public class solution2_2 {
  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] canWordBreak = new boolean[s.length() + 1];
    canWordBreak[s.length()] = true;
    for (int i = s.length() - 1; 0 <= i; i--) {
      String sub = s.substring(i);
      for (String word : wordDict) {
        if (sub.startsWith(word) && canWordBreak[i + word.length()]) {
          canWordBreak[i] = true;
        }
      }
    }
    return canWordBreak[0];
  }
}
