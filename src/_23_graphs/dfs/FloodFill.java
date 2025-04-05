package _23_graphs.dfs;
//https://leetcode.com/problems/flood-fill/
public class FloodFill {
    private void dfs(int sr, int sc, int[][] ans, int[][] image, int color, int[] deltaRow, int[] deltaCol, int initColor){
        ans[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i = 0; i < 4; i++){
            int nrow = sr + deltaRow[i];
            int ncol = sc + deltaCol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initColor && ans[nrow][ncol] != color){
                dfs(nrow,ncol,ans,image,color,deltaRow,deltaCol,initColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initColor = image[sr][sc];
        int[][] ans = image;
        int deltaRow[] = {-1,0,+1,0};
        int deltaCol[] = {0,+1,0,-1};
        dfs(sr,sc,ans,image,color,deltaRow,deltaCol,initColor);
        return ans;
    }
}
