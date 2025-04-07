package _23_graphs.shortest_path_algo;
//https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
import java.util.*;
public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        // If the starting or ending cell is blocked, return -1 immediately.
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;
        // Define the 8 possible directions (vertical, horizontal, and diagonal)
        int[][] directions = {
                {1, 0}, {0, 1}, {1, 1},
                {-1, 0}, {0, -1}, {-1, -1},
                {-1, 1}, {1, -1}
        };
        // Use a queue to perform BFS; each entry is {row, col, steps}
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        // Mark the starting cell as visited.
        grid[0][0] = 1;
        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1], steps = cell[2];
            // If we've reached the bottom-right cell, return the number of steps.
            if (r == n - 1 && c == n - 1)
                return steps;
            // Explore all 8 possible directions.
            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                // Check boundaries and if the cell is clear (0)
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                    queue.add(new int[]{newRow, newCol, steps + 1});
                    // Mark the cell as visited.
                    grid[newRow][newCol] = 1;
                }
            }
        }
        return -1; // If we exhaust the queue without reaching the destination, return -1.
    }
}
