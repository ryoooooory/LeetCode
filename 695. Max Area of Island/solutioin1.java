class solution1 {
    public int maxAreaOfIsland(int[][] grid) {
        int rowLimit = grid.length;
        int columnLimit = grid[0].length;
        boolean[][] visited = new boolean[rowLimit][columnLimit];

        Queue<Position> queue = new LinkedList<Position>();
        int maxIsland = 0;

        for(int row = 0; row < rowLimit; row++) {
            for (int col = 0; col < columnLimit; col++) {
                if (visited[row][col]) {
                    continue;
                }
                visited[row][col] = true;
                if (grid[row][col] == 0) {
                    continue;
                }
                Position start = new Position(row, col);
                queue.add(start);
                int islandCount = 0;
                while(!queue.isEmpty()) {
                    islandCount++;
                    Position current = queue.poll();
                    int[] deltaRow = {0,1,0,-1};
                    int[] deltaCol = {1,0,-1,0};
                    for(int i = 0; i < 4; i++) {
                        int nextRow = deltaRow[i] + current.row;
                        int nextCol = deltaCol[i] + current.col;
                        if (0 <= nextRow && nextRow < rowLimit && 0 <= nextCol && nextCol < columnLimit && grid[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                            Position nextPosition = new Position(nextRow, nextCol);
                            queue.add(nextPosition);
                            visited[nextRow][nextCol] = true;
                        } 
                    }
                }
                maxIsland = Math.max(islandCount, maxIsland);
            }
        }
        return maxIsland;
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