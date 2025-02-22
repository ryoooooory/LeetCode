public class solution2_2 {
  static final int LAND = 1;
  static final int WATER = 0;
  static final int[][] delta = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public int maxAreaOfIsland(int[][] grid) {
    int rowLimit = grid.length;
    int columnLimit = grid[0].length;
    boolean[][] visited = new boolean[rowLimit][columnLimit];
    int maxIsland = 0;

    for (int row = 0; row < rowLimit; row++) {
      for (int col = 0; col < columnLimit; col++) {
        if (visited[row][col]) {
          continue;
        }
        visited[row][col] = true;
        if (grid[row][col] == WATER) {
          continue;
        }
        maxIsland = Math.max(maxIsland, countIslandArea(grid, visited, row, col));
      }
    }
    return maxIsland;
  }

  int countIslandArea(int[][] grid, boolean[][] visited, int currentRow, int currentCol) {
    int islandCount = 1;
    int rowLimit = grid.length;
    int columnLimit = grid[0].length;
    for (int i = 0; i < 4; i++) {
      int nextRow = delta[i][0] + currentRow;
      int nextCol = delta[i][1] + currentCol;
      if (0 <= nextRow
          && nextRow < rowLimit
          && 0 <= nextCol
          && nextCol < columnLimit
          && grid[nextRow][nextCol] == LAND
          && !visited[nextRow][nextCol]) {
        visited[nextRow][nextCol] = true;
        islandCount += countIslandArea(grid, visited, nextRow, nextCol);
      }
    }
    return islandCount;
  }
}
