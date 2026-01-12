/*
 * ・概要
 * 自力解法
 * 練習のため再帰バージョンでも書いてみた。やはりDPのが直感的な気がする。
 * 注意点として、ゴール地点に障害物があるケースもある。（これで１回とおらなかった。）
 *
 * ・計算量
 * 時間：O(row * col)
 * 空間: O(row * col)
 */

public class solution1_2 {
  private static final int OBSTACLE = 1;

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }
    int rowLimit = obstacleGrid.length;
    int colLimit = obstacleGrid[0].length;
    int[][] memo = new int[rowLimit][colLimit];
    for (int row = 0; row < rowLimit; row++) {
      Arrays.fill(memo[row], -1);
    }
    return countPaths(obstacleGrid, 0, 0, rowLimit - 1, colLimit - 1, memo);
  }

  private int countPaths(
      int[][] obstacleGrid, int row, int col, int goalRow, int goalCol, int[][] memo) {
    if (goalRow < row || goalCol < col) {
      return 0;
    }
    if (obstacleGrid[row][col] == OBSTACLE) {
      return 0;
    }
    if (row == goalRow && col == goalCol) {
      return 1;
    }
    if (memo[row][col] != -1) {
      return memo[row][col];
    }
    memo[row][col] =
        countPaths(obstacleGrid, row + 1, col, goalRow, goalCol, memo)
            + countPaths(obstacleGrid, row, col + 1, goalRow, goalCol, memo);
    return memo[row][col];
  }
}
