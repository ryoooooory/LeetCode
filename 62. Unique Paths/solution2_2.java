/*
 * ・概要
 * 他の人のPR参考にしたもの
 * https://github.com/Fuminiton/LeetCode/pull/33/files
 * 1次元配列にする方法。まあ２次元配列の方が直感的なのでよほどメモリが問題でなければ２次元のがいいなあくらいのイメージ
 */

public class solution2_2 {
  public int uniquePaths(int m, int n) {
    if (m < 0 || n < 0) {
      return 0;
    }
    int[] countOfPath = new int[n];
    countOfPath[0] = 1;
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (row == 0 || col == 0) {
          countOfPath[col] = 1;
        } else {
          countOfPath[col] = countOfPath[col - 1] + countOfPath[col];
        }
      }
    }
    return countOfPath[n - 1];
  }
}
