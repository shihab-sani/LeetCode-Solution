import java.util.ArrayDeque;
import java.util.Deque;

class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> que = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    que.add(new int[]{i, j});
                }
            }
        }

        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (fresh > 0 && !que.isEmpty()) {
            int length = que.size();
            for (int i = 0; i < length; i++) {
                int[] pair = que.poll();
                int row = pair[0];
                int col = pair[1];

                for (int[] dir : direction) {
                    int new_row = row + dir[0];
                    int new_col = col + dir[1];

                    if (new_row >= 0 && new_col >= 0 && new_row < grid.length && new_col < grid[0].length && grid[new_row][new_col] == 1) {
                        grid[new_row][new_col] = 2;
                        que.add(new int[]{new_row, new_col});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}