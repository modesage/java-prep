package _10_recursion._8_backtracking_intro;

import java.util.Arrays;

public class MazeAllPaths {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        //starting position 0,0
//        allPath("", board,0,0);
        int[][] path = new int[board.length][board[0].length];
        allPathPrint("", board, 0, 0, path, 1);
    }

    //using backtracking
    //goal is to reach 2,2
    static void allPath(String p, boolean[][] maze, int r, int c) {
        //when reaching goal position
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        //if any block is false, then return
        //meaning already visited in the current path
        if (!maze[r][c]) {
            return;
        }

        //considering this block in current path
        maze[r][c] = false;

        if (r < maze.length - 1) {
            //giving the saved moves + down, the maze, row + 1, col as it is
            //going down
            allPath(p + 'D', maze, r+1, c);
        }

        if (c < maze[0].length - 1) {
            //going right
            allPath(p + 'R', maze, r, c+1);
        }

        if (r > 0) {
            //going up
            allPath(p + 'U', maze, r-1, c);
        }

        if (c > 0) {
            //doing down
            allPath(p + 'L', maze, r, c-1);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
        //resetting the block to original state, when backtracking the path
        maze[r][c] = true;
    }

    // This method prints all possible paths in a maze with step-by-step numbering.
    static void allPathPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        // Base case: if the destination (bottom-right corner) is reached
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            // Mark the current cell with the current step
            path[r][c] = step;

            // Print the maze with the path numbers
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }

            // Print the path itself
            System.out.println(p);
            System.out.println();
            return;
        }

        // If the current cell is blocked or already visited, exit
        if (!maze[r][c]) {
            return;
        }

        // Mark the current cell as visited (part of the current path)
        maze[r][c] = false;
        path[r][c] = step;  // Record the current step at this cell

        // Explore moving down if possible (to the next row)
        if (r < maze.length - 1) {
            // Move down and increase the step count
            allPathPrint(p + 'D', maze, r + 1, c, path, step + 1);
        }

        // Explore moving right if possible (to the next column)
        if (c < maze[0].length - 1) {
            // Move right and increase the step count
            allPathPrint(p + 'R', maze, r, c + 1, path, step + 1);
        }

        // Explore moving up if possible (to the previous row)
        if (r > 0) {
            // Move up and increase the step count
            allPathPrint(p + 'U', maze, r - 1, c, path, step + 1);
        }

        // Explore moving left if possible (to the previous column)
        if (c > 0) {
            // Move left and increase the step count
            allPathPrint(p + 'L', maze, r, c - 1, path, step + 1);
        }

        // Backtracking step: reset the current cell and step
        maze[r][c] = true;  // Unmark the current cell as part of the path
        path[r][c] = 0;     // Reset the step number for this cell
    }
}
