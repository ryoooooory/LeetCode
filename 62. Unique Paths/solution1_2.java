/*
 * ・概要
 * 自力解法
 * solution1_1のメモ化バージョン
 *
 * ・計算量
 * 時間：O(n*m), 各マス１回ずつしか走査しなくてすむので
 * 空間：O(n*m)
 */

public class soluion1_2 {
  public int uniquePaths(int m, int n) {
    if (m < 0 || n < 0) {
      return 0;
    }
    return countPath(0, 0, m - 1, n - 1, new int[m][n]);
  }

  private int countPath(int row, int col, int goalRow, int goalCol, int[][] memo) {
    if (goalRow < row || goalCol < col) {
      return 0;
    }
    if (row == goalRow && col == goalCol) {
      return 1;
    }
    if (memo[row][col] != 0) {
      return memo[row][col];
    }
    memo[row][col] =
        countPath(row + 1, col, goalRow, goalCol, memo)
            + countPath(row, col + 1, goalRow, goalCol, memo);
    return memo[row][col];
  }
}
