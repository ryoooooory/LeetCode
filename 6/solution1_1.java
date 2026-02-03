/*
・概要
自力解法。25分くらいでAC,途中エッジケースで３回くらいWA。

・解き方。
指定通りの操作で、charの２次元配列にマッピングして、最後に文字列を作っていく

・計算量
時間：O(r * n) n = 1000なので、10μsくらいでおわりそう。
空間：O(r * n)

・所感
やはりwhile内での２重ループや違う動きをループないで行うと管理が煩雑になりエッジケースでミスりがちになるなと思った。
*/

public class solution1_1 {
  // abcdefg r = 3 > aebdfcg
  // a   e
  // b d f
  // c   g
  // 奇数番目のrは、r - 2個ある。
  // 配列つくるとまあ簡単かも。制約的にも1000 * 1000なのでいけるかも。
  // 最後に配列からStringを作っていく。

  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    int numCols = 0;
    int length = s.length();
    while (0 <= length) {
      numCols++;
      length -= numRows;
      if (length < 0) {
        break;
      }
      for (int i = 0; i < numRows - 2; i++) {
        if (length < 0) {
          break;
        }
        numCols++;
        length--;
      }
    }
    int index = 0;
    int row = 0;
    int col = 0;
    char[][] charMap = new char[numRows][numCols];
    for (int r = 0; r < numRows; r++) {
      for (int c = 0; c < numCols; c++) {
        charMap[r][c] = '0';
      }
    }
    length = s.length();
    while (index != length) {
      // 縦
      for (int i = 0; i < numRows; i++) {
        if (index == length) {
          break;
        }
        charMap[row][col] = s.charAt(index);
        row++;
        index++;
      }
      if (index == length) {
        break;
      }
      // 右上
      row = numRows - 2;
      col++;
      for (int i = 0; i < numRows - 2; i++) {
        if (index == length) {
          break;
        }
        charMap[row][col] = s.charAt(index);
        row--;
        col++;
        index++;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int r = 0; r < numRows; r++) {
      for (int c = 0; c < numCols; c++) {
        char current = charMap[r][c];
        if (current == '0') {
          continue;
        }
        sb.append(current);
      }
    }
    return new String(sb);
  }
}
