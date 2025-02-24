import java.util.LinkedList;
import java.util.Queue;

class solution3 {
  private static final int LAND = 1;
  private static final int WATER = 0;

  public int maxAreaOfIsland(int[][] grid) {
    int maxIslandArea = 0;
    int height = grid.length;
    int width = grid[0].length;
    boolean[][] visited = new boolean[height][width];

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        if (grid[row][col] == WATER || visited[row][col]) {
          continue;
        }
        visited[row][col] = true;
        int islandArea = countIslandArea(grid, visited, row, col);
        maxIslandArea = Math.max(maxIslandArea, islandArea);
      }
    }
    return maxIslandArea;
  }

  private int countIslandArea(int[][] grid, boolean[][] visited, int row, int col) {
    int islandArea = 0;
    Queue<Position> islands = new LinkedList<>();
    islands.add(new Position(row, col));
    while (!islands.isEmpty()) {
      Position current = islands.poll();
      islandArea++;
      addLand(current.row + 1, current.col, islands, grid, visited);
      addLand(current.row - 1, current.col, islands, grid, visited);
      addLand(current.row, current.col + 1, islands, grid, visited);
      addLand(current.row, current.col - 1, islands, grid, visited);
    }
    return islandArea;
  }

  private void addLand(int row, int col, Queue islands, int[][] grid, boolean[][] visited) {
    int height = grid.length;
    int width = grid[0].length;
    if (!(0 <= row && row < height && 0 <= col && col < width)) {
      return;
    }
    if (grid[row][col] != LAND) {
      return;
    }
    if (visited[row][col]) {
      return;
    }
    visited[row][col] = true;
    islands.add(new Position(row, col));
  }

  private record Position(int row, int col) {}
}
