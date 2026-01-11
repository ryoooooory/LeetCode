/*
・概要
自力解法。５分ほどでAC

・計算量
時間：O(n) n:tの文字列の長さ。nは10^4なので、0.1msくらいで完了できそう
計算：O(1)


・解き方
indexを使って、tを探索しながらsのindex番目の文字と一致するかをみていく。
いわゆる2ポインタかな



*/
public class solution1_1 {
  public boolean isSubsequence(String s, String t) {
    if (s.length() == 0) {
      return true;
    }
    int index = 0;
    for (char c : t.toCharArray()) {
      if (c == s.charAt(index)) {
        index++;
        if (s.length() == index) {
          return true;
        }
      }
    }
    return false;
  }
}
