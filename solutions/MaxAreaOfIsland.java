class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    islands = Math.max(islands, helper(grid, i, j , new int[grid.length][grid[0].length]));
                }
            }
        }
        return islands;
    }

    private int helper(int[][] grid, int i, int j, int[][] visit) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0 || visit[i][j] == 1) {
            return 0;
        }

        visit[i][j] = 1;
        return (1 + helper(grid, i + 1, j, visit) + helper(grid, i - 1, j, visit) + helper(grid, i, j + 1, visit) + helper(grid, i, j - 1, visit));
    }
}