package _23_graphs.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    void dfs(int node, boolean[] visitedArr, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls){
        //marking current node as visited
        visitedArr[node] = true;
        ls.add(node);
        //getting neighbour node
        for(Integer it: adj.get(node)){
            if(!visitedArr[node]){
                dfs(node,visitedArr,adj,ls);
            }
        }
    }
    //returning the list containing the dfs traversal of the graph
    ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj){
        boolean[] visitedArr = new boolean[v+1];
        visitedArr[0] = true;
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0,visitedArr,adj,ls);
        return ls;
    }
    //cycle detection in undirected graph
    boolean dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        for(int adjacentNode: adj.get(node)){
            if(vis[adjacentNode] == 0){
                if(dfs(adjacentNode, node, vis, adj)){
                    return true;
                }
            }
            else if(adjacentNode != parent) return true;
        }
        return false;
    }
    boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj){
        int[] vis = new  int[v];
        for(int i = 0; i < v; i++){
            if(vis[i] == 0){
                if(dfs(i, -1, vis, adj)) return true;
            }
        }
        return false;
    }

    //isBipartite
    private boolean dfsNow(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adj){
        color[node] = col;
        for(int it : adj.get(node)){
            if(color[it] == -1){
                if(!dfs(it, 1-col, color, adj)){
                    return false;
                }
            }
            else if(color[it] == col){
                return false;
            }
        }
        return false;
    }
    boolean isBipartite(int v, ArrayList<ArrayList<Integer>> adj){
        int[] color= new int[v];
        Arrays.fill(color, -1);
        for(int i = 0; i < v; i++){
            if(color[i] == -1){
                if(!dfsNow(i,0,color,adj)){
                    return false;
                }
            }
        }
        return true;
    }
    //cycle detection in directed graph
    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis){
        vis[node] = 1;
        pathVis[node] = 1;
        //traverse for adjacent nodes
        for(int it : adj.get(node)){
            //when the node is not visited
            if(vis[it] == 0){
                if(dfsCheck(it,adj,vis,pathVis)){
                    return true;
                }
                //if the node has been previously visited
                //but it has to be visited on the same path
                else if(pathVis[it] == 1){
                    return true;
                }
            }
        }
        pathVis[node] = 0;
        return false;
    }
    boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[v];
        int[] pathVis = new int[v];
        for(int i = 0; i < v; i++){
            if(vis[i] == 0){
                if(dfsCheck(i,adj,vis,pathVis)){
                    return true;
                }
            }
        }
        return false;
    }

    //topological sort
    //only valid in DAG(directed acyclic graph)
    //linear ordering of vertices such that if there is an edge between u & v, u appears before v in that ordering
    private void dfs(int node, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it,vis,st,adj);
            }
        }
        st.push(node);
    }
    //returning array containing vertices in Topological order.
    int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[v];
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i < v; i++){
            if(vis[i] == 0){
                dfs(i,vis,st,adj);
            }
        }
        int[] ans = new int[v];
        int i = 0;
        while(!st.isEmpty()){
            ans[i++] = st.peek();
            st.pop();
        }
        return ans;
    }



}
