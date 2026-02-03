/*
・概要
LeetCode解法や他の人のPRを参考にした。

他の人のPRを参考にした。

https://github.com/shintaro1993/arai60/pull/63/files
https://github.com/akmhmgc/arai60/pull/51/files
pythonやRubyは桁の最大値とかみなくていいのか。
まあでも、計算量を改善するときは結局同じように32ビット最大値、最小値と比較する必要あるなと思った。

https://github.com/akmhmgc/arai60/pull/51/files
正規表現使ってる。すごい

https://github.com/akmhmgc/arai60/pull/51/files#r2425530301
limitを先に定義しておいてそれと比較するのか

https://github.com/potrue/leetcode/pull/59/files#r2307547126
ちょっときになったのでisDigitについて調べてみた。
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Character.html#isDigit-char-
isDigitでは、Unicode文字範囲の中の数字表現に全て対応しているので、半角数字だけでなく例えば全角数字やアラビア数字でも数字に変換する。
この問題の制約上それらはでることはないが、ここらへんは面接では議論したい。
仮に半角数字だけとなった場合は、例えば '0' <= c && c <= '9'などで判定するのもよさそう。

ちなみにgetNumericValueについても調べた。
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Character.html#getNumericValue-char-
基本的に数字のcharを数値にするが、文字'A' - 'Z'なども数値として返却するので、アルゴリズムによっては注意が必要そう。


Leetcodeの解法はsolution1_1と同じだが以下の点が違いがある。
1, intの最大・最小の判定。
solution1_1では、longを使っていて少し冗長だったが、数字を繰り上げて更新する前に、現在がInteger.MAX_VALUEの最大/10を越しているか、またはInteger.MAX_VALUEの最大/10
と一致していて、次に加える値（digit）がInteger.MAX_VALUEの１の位より大きいかの時は、更新時に最大・最小（最大の１桁目で判定するのは、最大の方が１の桁が小さいから。）をこえるので最大・最小を返す。

2, 文字から数値の生成。
solution1_1では、Stackをつかって１の桁から作っていく方針だったが、こちらでは、indexを増やすごとにresult * 10をすれば同じことになるという手法。
charから数字にするのは、問題制約より半角数字しかないので、 c - '0'で対応する。

ということでLeetCodeの解法を参考に修正してみる。
*/

public class solution2_1 {
  public int myAtoi(String s) {
    int sign = 1;
    int result = 0;
    int index = 0;
    int length = s.length();
    while (index < length && s.charAt(index) == ' ') {
      index++;
    }
    if (index < length && s.charAt(index) == '+') {
      sign = 1;
      index++;
    } else if (index < length && s.charAt(index) == '-') {
      sign = -1;
      index++;
    }

    while (index < length && Character.isDigit(s.charAt(index))) {
      int digit = s.charAt(index) - '0';
      if (Integer.MAX_VALUE / 10 < result
          || Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < digit) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      result = 10 * result + digit;
      index++;
    }
    return sign * result;
  }
}
