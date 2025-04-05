package _23_graphs.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visitedArr = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visitedArr[0] = true;
        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);
            //get the adjacent vertices
            for(Integer it: adj.get(node)){
                if(!visitedArr[it]){
                    visitedArr[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }

    //cycle detection in undirected graph
    boolean checkForCycle(int src, int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[src] = true;
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(src, -1));
        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            for(int adjacentNode: adj.get(node)){
                if(!vis[adjacentNode]){
                    vis[adjacentNode] = true;
                    q.add(new Coordinate(adjacentNode, node));
                }
                else if(parent != adjacentNode){
                    return true;
                }
            }
        }
        return false;
    }
    boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[v];
        for(int i = 0; i < v; i++){
            if(!vis[i]){
                if(checkForCycle(i,v,adj,vis)){
                    return true;
                }
            }
        }
        return false;
    }

    // bipartite / bigraph
    //color the graph with 2 colors such that no adjacent nodes have same color
    //linear graphs with no cycles are always bigraph
    //any graph with even cycle length is also bigraph
    //hence any graph with odd length cycle can never be bigraph
    //https://leetcode.com/problems/is-graph-bipartite/description/
    private boolean check(int start, int[][] graph, int[] color){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        color[start] = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            for(int it: graph[node]){
                //if the adjacent node is yet not colored
                //you will give the opposite color of the node
                if(color[it] == -1){
                    color[it] = 1 - color[node];
                    q.add(it);
                }
                //if the adjacent node has the same color
                //someone did color it through some other path
                else if(color[it] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    boolean isBipartite(int[][] graph){
        int v = graph.length;
        int[] color = new int[v];
        Arrays.fill(color, -1);
        for(int i = 0; i < v; i++){
            if(color[i] == -1){
                if(!check(i, graph, color)){
                    return false;
                }
            }
        }
        return true;
    }

    // Topological Sort using Kahn's Algorithm (only valid for Directed Acyclic Graphs - DAG)
    // The goal is to find a linear ordering of vertices such that for every directed edge u → v,
    // vertex u comes before vertex v in the ordering.
    int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[v];
        // Step 1: Compute the indegree of each vertex (number of incoming edges).
        for(int i = 0; i < v; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        // Step 2: Add all vertices with zero indegree to the queue.
        for(int i = 0; i < v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int[] topo = new int[v]; // Array to store the topological sort order
        int i = 0;
        // Step 3: Process the queue
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo[i++] = node;
            // Step 4: For each neighbor of the current node, reduce the indegree by 1.
            // If the indegree of a neighbor becomes zero, add it to the queue.
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        // If the topological sort contains all vertices, return it.
        // Otherwise, there was a cycle, and we cannot produce a valid topological ordering.
        return topo;
    }

    //cycle detection in directed graph
    boolean topoSortCycleDetection(int v, ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[v];
        // Step 1: Compute the indegree of each vertex (number of incoming edges).
        for(int i = 0; i < v; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        // Step 2: Add all vertices with zero indegree to the queue.
        for(int i = 0; i < v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int count = 0;
        int i = 0;
        // Step 3: Process the queue
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            count++;
            // Step 4: For each neighbor of the current node, reduce the indegree by 1.
            // If the indegree of a neighbor becomes zero, add it to the queue.
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        // If the topological sort count is equal to the nodes, then there is no cycle
        // Otherwise, there was a cycle, and we cannot produce a valid topological ordering.
        if(count == v){
            return false;
        }
        else{
            return true;
        }
    }



}
class Coordinate{
    int first;
    int second;
    Coordinate(int first, int second){
        this.first = first;
        this.second = first;
    }
}