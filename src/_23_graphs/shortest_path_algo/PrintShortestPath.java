package _23_graphs.shortest_path_algo;

import java.util.*;

public class PrintShortestPath {
    // Function to compute the shortest path from node 1 to node n.
    // n: number of vertices, m: number of edges, edges: edge list where each edge is represented as [u, v, weight]
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        // Build the adjacency list. Since vertices are 1-indexed, we create n+1 lists.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        // Add each edge to the graph (undirected graph: add both directions)
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        // Priority queue (min-heap) to select the next node with the smallest distance.
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);

        // Initialize distances array and parent array.
        // We use n+1 size arrays since the vertices are 1-indexed.
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        // Set initial distances to a large value (simulate infinity) and each node as its own parent.
        for (int i = 0; i <= n; i++) {
            dist[i] = (int) 1e9;
            parent[i] = i;
        }
        // Starting node is 1; its distance is 0.
        dist[1] = 0;
        pq.add(new Pair(0, 1));

        // Dijkstra's algorithm: process nodes until the queue is empty.
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.second;
            int currDist = curr.first;

            // Explore all adjacent vertices.
            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.first;
                int edgeWeight = neighbor.second;
                // If a shorter path to adjNode is found, update its distance and parent.
                if (currDist + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = currDist + edgeWeight;
                    parent[adjNode] = node;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        // Build the shortest path from node 1 to node n using the parent array.
        List<Integer> path = new ArrayList<>();
        // If node n is unreachable, return [-1].
        if (dist[n] == (int) 1e9) {
            path.add(-1);
            return path;
        }

        // Backtrack from node n to node 1 using the parent pointers.
        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1); // Add the starting node.

        // The path was built in reverse order, so reverse it.
        Collections.reverse(path);
        return path;
    }
}