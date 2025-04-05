package _23_graphs.bfs;
//https://leetcode.com/problems/rotting-oranges/description/
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Point> q = new LinkedList<>();
        int[][] visitedArr = new int[n][m];
        int cntFresh = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new Point(i,j,0));
                    visitedArr[i][j] = 2;
                }
                else{
                    visitedArr[i][j] = 0;
                }
                if(grid[i][j] == 1) cntFresh++;
            }
        }
        int time = 0;
        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,1,0,-1};
        int cnt = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            time = Math.max(time,t);
            q.remove();
            for(int i = 0; i < 4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visitedArr[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    q.add(new Point(nrow, ncol, t + 1));
                    visitedArr[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }
        if(cnt != cntFresh) return -1;
        return time;
    }
}
class Point{
    int row;
    int col;
    int time;
    Point(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
