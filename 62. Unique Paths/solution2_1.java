/*
 * ・概要
 * 他の人のPR参考にしたもの
 *
 * https://github.com/irohafternoon/LeetCode/pull/36/files#r2075900092
 * DPの考えは同じだが、一部更新部分を変えたもの。
 * その他、最初にcol == 0, row == 0のdpを1で埋める方法もある。
 *
 *
 * https://github.com/Fuminiton/LeetCode/pull/33/files#r2052525099
 * https://github.com/saagchicken/coding_practice/pull/19/files#r2034669315
 * w,hは領域に使いたい→同意
 *
 */

public class solution2_1 {
  public int uniquePaths(int m, int n) {
    if (m < 0 || n < 0) {
      return 0;
    }
    int[][] countOfPath = new int[m][n];
    countOfPath[0][0] = 1;
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (0 < row) {
          countOfPath[row][col] += countOfPath[row - 1][col];
        }
        if (0 < col) {
          countOfPath[row][col] += countOfPath[row][col - 1];
        }
      }
    }
    return countOfPath[m - 1][n - 1];
  }
}
