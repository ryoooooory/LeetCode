/*
他の人の解法みた

https://github.com/Satorien/LeetCode/pull/56/files
なるほど、indexを保持して、sのindex番目の文字がtにあるかを前回見つかったindexから右側で探すのか。２重ループかな？

https://github.com/tokuhirat/LeetCode/pull/57/files
https://github.com/potrue/leetcode/pull/57/files
シンプル2ポインタ。whileって個人的に得意では無いので、どこかで練習しないとな
STEP２はかなり綺麗。STEP3は自分の解放とほぼ同じ

https://github.com/ryosuketc/leetcode_arai60/pull/57/files
s, tのバリデーションを最初にいれている。確かに、仕様次第では安全にするためにこういうことをよくするのでいいなと思った。
もし面接のときだったら、ここらへんは会話したい。

follow up
Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
についてはシンプルに考えると、sについてHashMapなどでメモ化しておくと、同じものを探索するときにすくかえせるから良さそう。もっと改善しようとすると、tについてHashMap<Character, List<Integer>>で各文字のindexを保持（複数もある）しておく。
各sについて探索するときは、sの各文字について、先ほどのMapをもとにindexをupperboundでもとめていくことでlogtで求めることができる。よって全体でO(k*s*logt)で可能
ということでwhileで実装してみる。

*/

public class solution2_1 {
  public boolean isSubsequence(String s, String t) {
    if (s.length() == 0) {
      return true;
    }
    int sIndex = 0;
    int tIndex = 0;
    while (sIndex < s.length() && tIndex < t.length()) {
      if (s.charAt(sIndex) == t.charAt(tIndex)) {
        sIndex++;
      }
      tIndex++;
    }
    return sIndex == s.length();
  }
}
