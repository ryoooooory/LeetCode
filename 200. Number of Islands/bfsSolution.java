class Solution {
    // テストケース
    // 111
    // 010
    // 001

    public int numIslands(char[][] grid) {
        // エッジケース処理
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int islandCounts = 0;
        int rowLimit = grid.length;
        int columnLimit = grid[0].length;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    islandCounts++;

                    Queue<int[]> connectedIsland = new LinkedList<>();
                    connectedIsland.add(new int[] {r, c});
                    while (!connectedIsland.isEmpty()) {
                        int[] currentIsland = connectedIsland.poll();
                        int currentRow = currentIsland[0];
                        int currentColumn = currentIsland[1];

                        if (currentRow + 1 < rowLimit
                                && grid[currentRow + 1][currentColumn] == '1') {
                            connectedIsland.add(new int[] {currentRow + 1, currentColumn});
                            grid[currentRow + 1][currentColumn] = '0';
                        }
                        if (0 <= currentRow - 1 && grid[currentRow - 1][currentColumn] == '1') {
                            connectedIsland.add(new int[] {currentRow - 1, currentColumn});
                            grid[currentRow - 1][currentColumn] = '0';
                        }
                        if (currentColumn + 1 < columnLimit
                                && grid[currentRow][currentColumn + 1] == '1') {
                            connectedIsland.add(new int[] {currentRow, currentColumn + 1});
                            grid[currentRow][currentColumn + 1] = '0';
                        }
                        if (0 <= currentColumn - 1 && grid[currentRow][currentColumn - 1] == '1') {
                            connectedIsland.add(new int[] {currentRow, currentColumn - 1});
                            grid[currentRow][currentColumn - 1] = '0';
                        }
                    }
                }
            }
        }
        return islandCounts;
    }
}
