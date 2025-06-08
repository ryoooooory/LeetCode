/*
 * https://github.com/irohafternoon/LeetCode/pull/37/files
 * numRow→良さそう！！
 *
 * https://github.com/Fuminiton/LeetCode/pull/34/files
 * ネストが少しだけ深いかも（個人的には今回は処理も単純なので許容くらいの感じ）ので、関数化してもいいかも
 *
 * https://github.com/olsen-blue/Arai60/pull/34/files#r1979987243
 * これは大事。実務ではここらへんはコミュニケーションすぐあ、信用できないので念の為バリデーションをする方針はよくとられがちなイメージ（僕の経験上）
 *
 * https://github.com/olsen-blue/Arai60/pull/34/files#r1979998266
 * たしかに、row,colくらいならr,cでも悪くないかなという気がしてきた。
 * https://google.github.io/styleguide/javaguide.html#s4.8.2-variable-declarations
 * ガイドをみてもループないならOKそう
 * 入力配列のバリデーションもやはり意識すべし
 * エッジ初期化を先にする手法。コード量は増えるがやってることは少し、明示的な気もするなくらいな気持ち。
 *
 */
public class solution2_1 {
  static int OBSTACLE = 1;

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int numOfRow = obstacleGrid.length;
    if (numOfRow == 0) {
      return 0;
    }
    int numOfCol = obstacleGrid[0].length;
    if (numOfCol == 0) {
      return 0;
    }
    if (obstacleGrid[0][0] == OBSTACLE || obstacleGrid[numOfRow - 1][numOfCol - 1] == OBSTACLE) {
      return 0;
    }
    int[][] numOfPaths = new int[numOfRow][numOfCol];
    numOfPaths[0][0] = 1;
    for (int c = 0; c < numOfCol; c++) {
      if (obstacleGrid[0][c] == OBSTACLE) {
        numOfPaths[0][c] = 0;
        break;
      } else {
        numOfPaths[0][c] = 1;
      }
    }
    for (int r = 0; r < numOfRow; r++) {
      if (obstacleGrid[r][0] == OBSTACLE) {
        numOfPaths[r][0] = 0;
        break;
      } else {
        numOfPaths[r][0] = 1;
      }
    }

    for (int r = 1; r < numOfRow; r++) {
      for (int c = 1; c < numOfCol; c++) {
        if (obstacleGrid[r][c] == OBSTACLE) {
          numOfPaths[r][c] = 0;
          continue;
        }
        if (r != 0) {
          numOfPaths[r][c] += numOfPaths[r - 1][c];
        }
        if (c != 0) {
          numOfPaths[r][c] += numOfPaths[r][c - 1];
        }
      }
    }
    return numOfPaths[numOfRow - 1][numOfCol - 1];
  }
}
