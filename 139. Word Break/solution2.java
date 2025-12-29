/*
・概要
LeetCodeの解法とhttps://github.com/5103246/LeetCode_Arai60/pull/37/files#diff-d47cadfa666e888fa6f7733f5a1ef36445b694f3145516369f324fbbd15c6ef6R46をみて実装したもの。
solution1の解法にメモ化を追加したもの。また、再起的に部分文字列を渡さなくてもindexだけ渡すだけで同じことができることに気づいたのでそちらで実装した。

・計算量
時間計算量：O(n^2 * m) n: sの長さ, m: wordDictの単語数
空間計算量：O(n) メモ配列の分

・所感
なぜメモ化で早くなるのかをちゃんと考えてみる。
メモ化をしない場合、同じindexから始まる部分文字列に対して何度もexistWordInDictを呼び出すことになる。つまり、indexが同じであれば、同じ計算を繰り返すことになる。
今回は再帰を使っていて、wordDictの中の単語を順番に試していくので、いろいろなルートで、indexが同じになることがある。
メモ化をすることで、一度計算したindexから始まる部分文字列に対しては、再度計算することなく、メモ配列から結果を取得できるようになる。
これにより、同じ計算を繰り返すことがなくなり、全体の計算量が削減される。
具体的には、最悪の場合でも各indexに対して一度だけexistWordInDictが呼び出されることになるため、時間計算量がO(n^2 * m)に抑えられる。(mはwordDictの単語数分だけ再帰内部でループするため)

https://github.com/nanae772/leetcode-arai60/pull/38/files
こちらも同様の解法だがPythonだとメモ化をマクロみたいな形でかけるのでべんりそうだな〜と思った。
*/
public class solution2 {
  public boolean wordBreak(String s, List<String> wordDict) {
    Boolean[] memo = new Boolean[s.length() + 1];
    return existWordInDict(s, 0, wordDict, memo);
  }

  private boolean existWordInDict(String target, int index, List<String> wordDict, Boolean[] memo) {
    if (index == target.length()) {
      return true;
    }
    if (memo[index] != null) {
      return memo[index];
    }
    for (String word : wordDict) {
      String targetSubString = target.substring(index);
      if (targetSubString.startsWith(word)) {
        int nextIndex = index + word.length();
        boolean existAllWordInDict = existWordInDict(target, nextIndex, wordDict, memo);
        memo[nextIndex] = existAllWordInDict;
        if (memo[nextIndex]) {
          return true;
        }
      }
    }
    memo[index] = false;
    return memo[index];
  }
}
