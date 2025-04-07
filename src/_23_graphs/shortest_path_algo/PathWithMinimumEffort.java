package _23_graphs.shortest_path_algo;
//https://leetcode.com/problems/path-with-minimum-effort/description/
import java.util.*;
public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // effort[r][c] will store the minimum effort required to reach cell (r, c)
        int[][] effort = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                effort[r][c] = Integer.MAX_VALUE;
            }
        }
        effort[0][0] = 0;
        // Priority queue to hold {currentEffort, row, col}.
        // We always pick the cell with the least effort so far.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int curEffort = current[0], r = current[1], c = current[2];
            if (r == rows - 1 && c == cols - 1) {
                return curEffort;
            }
            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    // Calculate the effort required to move to the neighbor.
                    int nextEffort = Math.max(curEffort, Math.abs(heights[newRow][newCol] - heights[r][c]));
                    // If this path offers a smaller maximum effort, update and add neighbor to the queue.
                    if (nextEffort < effort[newRow][newCol]) {
                        effort[newRow][newCol] = nextEffort;
                        pq.offer(new int[]{nextEffort, newRow, newCol});
                    }
                }
            }
        }
        return 0; // Should not reach here if input is valid.
    }
}
