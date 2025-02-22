public class solution2_1 {
  static final int LAND = 1;
  static final int WATER = 0;

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
        maxIsland = Math.max(maxIsland, countIslandArea(grid, visited, new Position(row, col)));
      }
    }
    return maxIsland;
  }

  int countIslandArea(int[][] grid, boolean[][] visited, Position start) {
    Queue<Position> queue = new LinkedList<Position>();
    queue.add(start);
    int islandCount = 0;
    int rowLimit = grid.length;
    int columnLimit = grid[0].length;
    while (!queue.isEmpty()) {
      islandCount++;
      Position current = queue.poll();
      int[][] delta = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
      for (int i = 0; i < 4; i++) {
        int nextRow = delta[i][0] + current.row;
        int nextCol = delta[i][1] + current.col;
        if (0 <= nextRow
            && nextRow < rowLimit
            && 0 <= nextCol
            && nextCol < columnLimit
            && grid[nextRow][nextCol] == LAND
            && !visited[nextRow][nextCol]) {
          Position nextPosition = new Position(nextRow, nextCol);
          queue.add(nextPosition);
          visited[nextRow][nextCol] = true;
        }
      }
    }
    return islandCount;
  }

  class Position {
    int row;
    int col;

    Position(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }
}
