/*
 * ・概要
 * solution1_1をもとに、変数についてリファクタリングしてみた。
 * https://github.com/tokuhirat/LeetCode/pull/30/files は変数名について（one_consecutive、two_consecutive）としている。個人的には漸化式と一致しない（１段頭の中で変換が必要）ので直接1つ前の結果みたいにした方が好き
 * あと、結果をいれる変数がないのでtmpを作る必要がある。
 *
 * https://github.com/Fuminiton/LeetCode/pull/30/files#r2039291209
 * 漸化式をぱっと見てもわかるようにコードコメントいれるのは確かにと思った。（そら一目でわかる人はいないし）
 *
 * https://github.com/TORUS0818/leetcode/blob/50d9a5f46afbe969f08a116f412232e540ca159d/easy/276/answer.md
 * num_ways_2steps_backを変数でつかっていて直感的だなと思った。
 *
 * ・計算量
 * 時間計算量：O(n)
 * 空間計算量：O(1)
 *
 * ・その他
 * 問題ルール的には大丈夫だが、やはり引数について最初にバリデーションしたい。
 *
 */
public class solution2_1 {
  public int numWays(int n, int k) {
    if (n == 1) {
      return k;
    }
    if (n == 2) {
      return k * k;
    }
    int countOfPatternsTwoStepBack = k;
    int countOfPatternsOneStepBack = k * k;
    int countOfPatterns = countOfPatternsOneStepBack;
    for (int i = 3; i <= n; i++) {
      countOfPatterns = (k - 1) * (countOfPatternsTwoStepBack + countOfPatternsOneStepBack); // 3つ目以降のフェンスでは、i番目の場合の数は(i-1)番目のフェンスと同じ色を塗る時の場合の数と、違う色を塗る時の場合の数の合計値となる。
      countOfPatternsTwoStepBack = countOfPatternsOneStepBack;
      countOfPatternsOneStepBack = countOfPatterns;
    }
    return countOfPatterns;
  }
}
