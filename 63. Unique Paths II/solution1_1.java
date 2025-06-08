/*
 * ・概要
 * 自力解法
 * 一つ前のUniquePathと同様の方法を思いついた（動的計画法）。違いは障害物があればpathを0にするくらい。
 * 注意点として、スタート地点に障害物があるケースもある。（これで１回とおらなかった。）
 *
 * ・計算量
 * 時間：O(row * col)
 * 空間: O(row * col)
 *
 * ・その他
 * ループないで障害物みるからl22でとりあえず1いれてるけど逆にわかりにくいかもしれない
 * UniquePathと同じように１次元配列でもできるなという思い（ちょっとわかりにくくはなるが）
 */

public class solution1_1 {
  private static final int OBSTACLE = 1;

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int rowLimit = obstacleGrid.length;
    int colLimit = obstacleGrid[0].length;
    int[][] numOfPaths = new int[rowLimit][colLimit];
    numOfPaths[0][0] = 1;
    for (int row = 0; row < rowLimit; row++) {
      for (int col = 0; col < colLimit; col++) {
        if (obstacleGrid[row][col] == OBSTACLE) {
          numOfPaths[row][col] = 0;
          continue;
        }
        if (row != 0) {
          numOfPaths[row][col] += numOfPaths[row - 1][col];
        }
        if (col != 0) {
          numOfPaths[row][col] += numOfPaths[row][col - 1];
        }
      }
    }
    return numOfPaths[rowLimit - 1][colLimit - 1];
  }
}
