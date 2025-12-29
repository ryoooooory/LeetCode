/*
 * ・概要
 * 自力解法
 * ボトムアップでもできるなと思い、動的計画法を使った。
 * row!=0 && col!=0のときは、dp[row][col] = dp[row - 1][col] + dp[row][col - 1]となる、（上左からしかこれないので）
 *
 * ・計算量
 * 時間：O(n*m)
 * 空間：O(n*m)
 */

public class solution1_3 {
  public int uniquePaths(int m, int n) {
    if (m < 0 || n < 0) {
      return 0;
    }
    int[][] countOfPath = new int[m][n];
    countOfPath[0][0] = 1;
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (row == 0) {
          countOfPath[row][col] = 1;
        } else if (col == 0) {
          countOfPath[row][col] = 1;
        } else {
          countOfPath[row][col] = countOfPath[row - 1][col] + countOfPath[row][col - 1];
        }
      }
    }
    return countOfPath[m - 1][n - 1];
  }
}
