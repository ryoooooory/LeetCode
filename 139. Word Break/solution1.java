/*
    ・概要
       自力解法
       TLEだった。

   ・方針
       再帰的に単語辞書に含まれる単語で始まるかを確認し、含まれる場合はその単語を取り除いた残りの文字列で同様の処理を行う。
       文字列が空になった場合はtrueを返す。

   ・計算量
       時間計算量：O(n^m？) n: wordDictの要素数, m: sの長さ
       空間計算量：O(m)

   ・所感
       startsWithメソッドを知らなかった。便利。
       方針は悪くないと思うが、計算量の改善が思いつかなかった。
*/

public class solution1 {
  public boolean wordBreak(String s, List<String> wordDict) {
    return existWordInDict(s, 0, wordDict);
  }

  private boolean existWordInDict(String currentWord, int index, List<String> wordDict) {
    if (currentWord.isEmpty()) {
      return true;
    }
    for (String word : wordDict) {
      if (currentWord.startsWith(word)) { // 知らなかった。
        boolean existAllWordInDict =
            existWordInDict(currentWord.substring(word.length()), index + 1, wordDict);
        if (existAllWordInDict) {
          return true;
        }
      }
    }
    return false;
  }
}
