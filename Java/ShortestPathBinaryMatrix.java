
import java.util.ArrayDeque;
import java.util.Deque;

class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] != 0 || grid[rows - 1][cols - 1] != 0) {
            return -1;
        }
        
        int length = 1;
        int[][] visit = new int[rows][cols];
        Deque<int[]> que = new ArrayDeque<>();

        que.add(new int[2]);
        visit[0][0] = 1;

        while (!que.isEmpty()) {
            int qlength = que.size();
            for (int i = 0; i < qlength; i++) {
                int[] pair = que.poll();
                int row = pair[0], col = pair[1];
                if (row == (rows - 1) && col == (cols - 1)) {
                    return length;
                }

                int[][] direction = {{row + 1, col}, {row + 1, col + 1}, {row + 1, col - 1}, {row - 1, col}, {row - 1, col + 1}, {row - 1, col - 1}, {row, col + 1}, {row, col - 1}};
                for (int j = 0; j < 8; j++) {
                    int new_row = direction[j][0], new_col = direction[j][1];
                    if (Math.min(new_row, new_col) < 0 || new_row == rows || new_col == cols || visit[new_row][new_col] == 1 || grid[new_row][new_col] == 1) {
                        continue;
                    }

                    que.add(direction[j]);
                    visit[new_row][new_col] = 1;
                }
            }
            length++;
        }
        return -1;
    }
}