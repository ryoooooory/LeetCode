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
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == '1') {
                    islandCounts++;
                    searchConnectedIslandByDFS(grid, r, c);
                }
            }
        }
        return islandCounts;
    }

    private void searchConnectedIslandByDFS(char[][] grid, int currentRow, int currentColumn) {
        int rowLimit = grid.length;
        int columnLimit = grid[0].length;
        if(currentRow < 0 || rowLimit <= currentRow || currentColumn < 0 || columnLimit <= currentColumn || grid[currentRow][currentColumn] == '0') {
            return;
        }
        grid[currentRow][currentColumn] = '0';
        searchConnectedIslandByDFS(grid, currentRow + 1, currentColumn);
        searchConnectedIslandByDFS(grid, currentRow - 1, currentColumn);
        searchConnectedIslandByDFS(grid, currentRow, currentColumn + 1);
        searchConnectedIslandByDFS(grid, currentRow, currentColumn - 1);
    }
}
