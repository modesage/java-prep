package _23_graphs.dfs;
//https://leetcode.com/problems/find-eventual-safe-states/description/
import java.util.ArrayList;
import java.util.List;

public class EventualSafeNodes {
    private boolean dfsCheck(int node, int[][] adj, int[] vis, int[] pathVis, int[] check){
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        //traverse for adjacent nodes
        for(int it : adj[node]){
            //when the node is not visited
            if(vis[it] == 0){
                if(dfsCheck(it, adj, vis, pathVis, check)){
                    return true;
                }
            }
            //if the node has been previously visited
            //but it has to be visited on the same path
            else if(pathVis[it] == 1){
                return true;
            }
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        int[] vis = new int[v];
        int[] pathVis = new int[v];
        int[] check = new int[v];
        for(int i = 0; i < v; i++){
            if(vis[i] == 0){
                dfsCheck(i,graph,vis,pathVis,check);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < v; i++){
            if(check[i] == 1){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}
