class Solution {

    // union find
    class ConnectedField {
        private int[] parent;
        private int[] depth;
        private int uniqueIslandCount;

        ConnectedField(int fieldCount) {
            parent = new int[fieldCount];
            depth = new int[fieldCount];
            uniqueIslandCount = 0;

            for (int i = 0; i < fieldCount; i++) {
                parent[i] = i;
            }
        }

        public int root(int fieldIndex) {
            if (fieldIndex == parent[fieldIndex]) {
                return fieldIndex;
            } else {
                // 経路圧縮
                return parent[fieldIndex] = root(parent[fieldIndex]);
            }
        }

        public void connect(int fieldIndex1, int fieldIndex2) {
            int root1 = root(fieldIndex1);
            int root2 = root(fieldIndex2);

            if (root1 == root2) {
                return;
            } else if (depth[root1] < depth[root2]) {
                parent[root1] = root2;
            } else if (depth[root2] < depth[root1]) {
                parent[root2] = root1;
            } else {
                parent[root1] = root2;
                depth[root2]++;
            }
            uniqueIslandCount--;
        }

        public void incrementUniqueIsland() {
            uniqueIslandCount++;
        }

        public int getUniqueIslandCount() {
            return uniqueIslandCount;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int rowLimit = grid.length;
        int columnLimit = grid[0].length;
        ConnectedField field = new ConnectedField(rowLimit * columnLimit);
        for (int r = 0; r < rowLimit; r++) {
            for (int c = 0; c < columnLimit; c++) {
                if (grid[r][c] == '1') {
                    field.incrementUniqueIsland();

                    if (0 <= r - 1 && grid[r - 1][c] == '1') {
                        field.connect((r - 1) * columnLimit + c, r * columnLimit + c);
                    }
                    if (r + 1 < rowLimit && grid[r + 1][c] == '1') {
                        field.connect((r + 1) * columnLimit + c, r * columnLimit + c);
                    }
                    if (0 <= c - 1 && grid[r][c - 1] == '1') {
                        field.connect(r * columnLimit + c - 1, r * columnLimit + c);
                    }
                    if (c + 1 < columnLimit && grid[r][c + 1] == '1') {
                        field.connect(r * columnLimit + c + 1, r * columnLimit + c);
                    }
                }
            }
        }
        return field.uniqueIslandCount;
    }
}
