/*
・概要
自力解法
5分ほどで思いつき、10分ほどで実装、何回かエッジケースの考慮漏れでWAになり、最終20分ほどでAC
実装していて気になった部分はコードコメントとして残す

・解き方
見た時に典型的なsliding windowの問題だと思った。
2つのポインタを動かし、まず先行ポインタをうごかしながら出現文字を記録していき、同じ文字がでたら後行ポインタを動かして、出現文字を削除していき、処理ごとにmaxを更新していくというもの

・計算量
時間、空間；O(n) nは文字列の長さ。

・所感
ある程度テストケースも出して、実装を頭で考えてからコードを書き出したがエッジケースなどがまだ全ては割り出せていない。
もうすこし簡単だが極端なエッジケースをパッと実装してからの見直しの時にだせると尚良い。（全パターン出してから全部完璧な実装は間に合わない可能性もあるので）
あと、Setでもそこまで問題ないが半角英小文字が限定されているならchar[]でも記録部分は代用できそう

*/

import java.util.HashSet;
import java.util.Set;

public class solution1_1 {
  // abcac abc 3
  // abcc abc 3
  // aabcb abc
  // O(s)
  // から文字
  public int lengthOfLongestSubstring(String s) {
    int longestLength = 0;
    int left = 0;
    int right = 0;
    Set<Character> charSet = new HashSet<Character>(); // もうすこしわかりやすい変数名ありそう・
    while (right < s.length()) { // l35とかぶっているので、なんとかしたい。
      while (right < s.length()) {
        if (charSet.contains(s.charAt(right))) {
          break;
        }
        longestLength = Math.max(longestLength, right - left + 1);
        charSet.add(s.charAt(right));
        right++;
      }
      // 文字列の終端まで確認できたので走査は終了
      if (s.length() <= right) {
        break;
      }
      while (left < right && s.charAt(left) != s.charAt(right)) {
        charSet.remove(s.charAt(left));
        left++;
        longestLength = Math.max(longestLength, right - left + 1); // 必要ないかも
      }
      right++;
      left++;
    }
    return longestLength;
  }
}
