import java.util.ArrayDeque;

class Solution {
    // テストケース
    // 111
    // 010
    // 001

    public int numIslands(char[][] grid) {
        // エッジケース処理
        int islandCount = 0;
        int rowLimit = grid.length;
        int columnLimit = grid[0].length;

        for (int row = 0; row < rowLimit; row++) {
            for (int column = 0; column < columnLimit; column++) {
                if (grid[row][column] != '1') {
                    continue;
                }
                islandCount++;
                Queue<int[]> connectedIsland = new ArrayDeque<>();
                connectedIsland.add(new int[] {row, column});
                while (!connectedIsland.isEmpty()) {
                    int[] currentPosition = connectedIsland.poll();
                    int[] deltaRow = {1, -1, 0, 0};
                    int[] deltaColumn = {0, 0, 1, -1};

                    for (int direction = 0; direction < 4; direction++) {
                        int currentRow = currentPosition[0] + deltaRow[direction];
                        int currentColumn = currentPosition[1] + deltaColumn[direction];

                        if (currentRow < 0 || rowLimit <= currentRow || currentColumn < 0
                                || columnLimit <= currentColumn
                                || grid[currentRow][currentColumn] != '1') {
                            continue;
                        }
                        connectedIsland.add(new int[] {currentRow, currentColumn});
                        grid[currentRow][currentColumn] = '0';
                    }
                }
            }
        }
        return islandCount;
    }
}
