/*
・概要
他の人のPRを参考にした。

https://github.com/shintaro1993/arai60/pull/64/files
各行についてマッピングせずに直接データ構造に前から入れていく方法。かつ方向を現在のrowによって木目tえそれによって次のrowを変える。

https://github.com/fuga-98/arai60/pull/57/files#r2123999899
動く処理をそれぞれ下方向、右上方向についてそれぞれ関数化していてよさそう。

https://github.com/Ryotaro25/leetcode_first60/pull/66/files#r2020118072
関連してJavaでの文字列操作周りについて調べてみる。
StringBuilderでの文字追加についての償却計算量
https://github.com/jeymak-trainee/arai60training/pull/5#discussion_r2385932767
StringBuilderは内部でchar配列を持っていて、追加のたびに容量が足りなくなったら、新しいchar配列を確保してコピーしている。
ある数nまで足し合わせたとき、容量拡張の回数はlogn
k回目の容量拡張の時は、O(2^k)のコピーが発生する。
なのでnまでのコピーコストの総和は
Σ_{k=1}^{log(n)} O(2^k)
= O(2^{log(n)+1} - 2) = O(2n - 2) = O(n)
なので、n回の追加に対してO(n)となり、1回あたりの償却計算量はO(1)となる。

StringBuilderとStringBufferの違いについて
https://github.com/katsukii/leetcode/pull/17#discussion_r2025574654
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/StringBuilder.html
StringBufferはスレッドセーフで、StringBuilderはスレッドセーフではない。（そのぶん、Builderの方が基本高速）


ということで、動きの部分を関数化して実装した。
*/

public class solution2_2 {
  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    int index = 0;
    int row = 0;
    List<StringBuilder> strings = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      strings.add(new StringBuilder());
    }
    while (index < s.length()) {
      index = moveDown(strings, s, numRows, index);
      index = moveUp(strings, s, numRows, index);
    }
    StringBuilder convertedString = new StringBuilder();
    for (StringBuilder string : strings) {
      convertedString.append(new String(string));
    }
    return new String(convertedString);
  }

  private int moveDown(List<StringBuilder> strings, String string, int numRows, int index) {
    int row = 0;
    while (row < numRows - 1 && index < string.length()) {
      strings.get(row).append(string.charAt(index));
      index++;
      row++;
    }
    return index;
  }

  private int moveUp(List<StringBuilder> strings, String string, int numRows, int index) {
    int row = numRows - 1;
    while (0 < row && index < string.length()) {
      strings.get(row).append(string.charAt(index));
      index++;
      row--;
    }
    return index;
  }
}
