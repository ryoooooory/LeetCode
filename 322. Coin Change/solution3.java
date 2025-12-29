/*
・概要
コメントいただいたところを踏まえつつ、別解を思いついたので実装。

・方針
DPで、部分文字列s[0:i]がwordDictの単語で構成できるかを管理する。
f(i): f(i) = f(i - word.len) && s.substring(i + word.len).equals(word)
・計算量
O(n*m*k): nはsの長さ、mはwordDictの単語数、kは単語の最大長
O(n)

*/

public class solution3 {
  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] canCreateSubstring = new boolean[s.length() + 1];
    canCreateSubstring[0] = true;
    for (int i = 0; i < s.length(); i++) {
      if (!canCreateSubstring[i]) {
        continue;
      }
      for (String word : wordDict) {
        if (s.length() < i + word.length()) {
          continue;
        }
        if (s.regionMatches(i, word, 0, word.length())) {
          canCreateSubstring[i + word.length()] = true;
        }
      }
    }
    return canCreateSubstring[s.length()];
  }
}
