package _23_graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/number-of-enclaves/
public class NumOfEnclaves {
    public int numEnclaves(int[][] grid) {
        Queue<PairNow> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //first row, first col, last row, last col
                if(i == 0 || j == 0 || i == m-1 || j == n-1){
                    if(grid[i][j] == 1){
                        q.add(new PairNow(i,j));
                        vis[i][j] = 1;
                    }
                }
            }
        }
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            //traverse all 4 directions
            for(int i = 0; i < 4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    q.add(new PairNow(nrow,ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}
class PairNow{
    int first;
    int second;
    PairNow(int first, int second){
        this.first = first;
        this.second = second;
    }
}