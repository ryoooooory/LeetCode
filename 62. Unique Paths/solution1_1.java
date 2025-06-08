/*
 * ・概要
 * 自力解法
 * ゴールからPathを１つずつ返す方法がすぐに思いついたので再帰で実装。
 * メモ化しないと何回も同じ位置で再帰をしていまうことになるが一旦実装。
 *
 * ・計算量
 * 時間：O(2^(m+n))
 * 空間：O(m+n)
 *
 * ・その他
 * あとからみかえすとl24, l27行目は不要そう。limitRow、limitColも微妙かも、goalRowとかのがいいかも？
 */

public class solution1_1 {
  public int uniquePaths(int m, int n) {
    if (m < 0 || n < 0) {
      return 0;
    }
    return countPath(0, 0, m - 1, n - 1);
  }

  private int countPath(int row, int col, int limitRow, int limitCol) {
    if (row < 0 || limitRow < row) {
      return 0;
    }
    if (col < 0 || limitCol < col) {
      return 0;
    }
    if (row == limitRow && col == limitCol) {
      return 1;
    }
    return countPath(row + 1, col, limitRow, limitCol)
        + countPath(row, col + 1, limitRow, limitCol);
  }
}
