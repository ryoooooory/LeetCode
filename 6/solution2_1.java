/*
・概要
LeetCodeのApproach 1: Simulate Zig-Zag Movement解法ではsolution1_1とほとんど同じだが、条件式がもう少し簡潔。
特に、whileの中の条件をindex < lengthでまとめることでifでbreakする必要がなくなっているのが良い。


*/

public class solution2_1 {
  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    int length = s.length();
    int sections = (int) Math.ceil(length / (2 * numRows - 2.0));
    int numCols = sections * (numRows - 1);
    int index = 0;
    int currentRow = 0;
    int currentCol = 0;
    char[][] charMap = new char[numRows][numCols];
    for (char[] row : charMap) {
      Arrays.fill(row, ' ');
    }
    while (index < length) {
      // 縦
      while (currentRow < numRows && index < length) {
        charMap[currentRow][currentCol] = s.charAt(index);
        currentRow++;
        index++;
      }
      // 右上
      currentRow = numRows - 2;
      currentCol++;
      while (0 < currentRow && currentCol < numCols && index < length) {
        charMap[currentRow][currentCol] = s.charAt(index);
        currentRow--;
        currentCol++;
        index++;
      }
    }

    StringBuilder convertedString = new StringBuilder();
    for (int r = 0; r < numRows; r++) {
      for (int c = 0; c < numCols; c++) {
        char current = charMap[r][c];
        if (current == ' ') {
          continue;
        }
        convertedString.append(current);
      }
    }
    return new String(convertedString);
  }
}
