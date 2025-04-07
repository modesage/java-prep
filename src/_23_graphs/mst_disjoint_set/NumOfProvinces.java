package _23_graphs.mst_disjoint_set;
//https://leetcode.com/problems/number-of-provinces/description/
public class NumOfProvinces {
    public int findCircleNum(int[][] isConnected){
        int V = isConnected.length;
        DisjointSet ds = new DisjointSet(V);
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(isConnected[i][j] == 1){
                    ds.unionBySize(i,j);
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < V; i++){
            if(ds.parent[i] == i) cnt++;
        }
        return cnt;
    }
}
