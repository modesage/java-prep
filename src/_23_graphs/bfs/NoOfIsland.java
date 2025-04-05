package _23_graphs.bfs;
//https://leetcode.com/problems/number-of-islands/

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIsland {
    private void bfs(int ro, int co, int[][] visitedArr, char[][] grid){
        visitedArr[ro][co] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(ro,co));
        int n = grid.length;
        int m = grid[0].length;

        // Only consider up, right, down, and left
        //this can be removed when we have diagonal direction as well
        //then we can simply use the nested for loop
        int[] deltarow = {-1, 0, 1, 0};
        int[] deltacol = {0, 1, 0, -1};

        while (!q.isEmpty()){
            Pair current = q.remove();
            int row = current.first;
            int col = current.second;
            //traverse in the neighbours and mark them if it is a land
            //this is when we cant go diagonal
            for (int i = 0; i < 4; i++) {
                int nrow = row + deltarow[i];
                int ncol = col + deltacol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        grid[nrow][ncol] == '1' && visitedArr[nrow][ncol] == 0) {
                    visitedArr[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
            /*
            //this is when we can go up,down,left,right,diagonal
            for(int deltarow = -1; deltarow <= 1; deltarow++){
                for(int deltacol = -1; deltacol <= 1; deltacol++){
                    int nrow = row + deltarow;
                    int ncol = col + deltacol;
                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && visitedArr[nrow][ncol] == 0){
                        visitedArr[nrow][ncol] = 1;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
            */
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visitedArr = new int[n][m];
        int count = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(visitedArr[row][col] == 0 && grid[row][col] == '1'){
                    count++;
                    bfs(row,col,visitedArr,grid);
                }
            }
        }
        return count;
    }
}

class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}