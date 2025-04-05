package _23_graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/01-matrix/description/
public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dist = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        // Initialize the distance matrix and add all 0 cells to the queue.
        // For 1s, we set the distance to a large value (e.g., m*n).
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    dist[i][j] = m * n; // max possible distance
                }
            }
        }

        // Directions for moving up, down, left, right.
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Perform BFS starting from all 0 cells.
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];

            for (int[] d : dirs) {
                int r = row + d[0];
                int c = col + d[1];

                // Check bounds and if we can relax the distance.
                if (r >= 0 && r < m && c >= 0 && c < n) {
                    if (dist[r][c] > dist[row][col] + 1) {
                        dist[r][c] = dist[row][col] + 1;
                        queue.offer(new int[]{r, c});
                    }
                }
            }
        }

        return dist;
    }
}
