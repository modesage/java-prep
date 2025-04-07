package _23_graphs.shortest_path_algo;
//https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
import java.util.*;

//dijkstra is not applicable to negative weight and negative weight cycle graphs
//time complexity
// E * log(V) ----> E = edges, V = vertices
public class DijkstraAlgorithm {
    public ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int v = adj.size();  // Number of vertices
        // Priority queue to store (distance, vertex) pairs; orders by distance.
        //we are taking priority queue as we want the min distance first
        PriorityQueue<iPair> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        // Initialize distances with a large value (simulate infinity)
        ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(v, (int) 1e9));
        dist.set(src, 0);  // Distance from src to itself is 0
        // Start with the source vertex
        pq.add(new iPair(0, src));
        // Process the graph
        while (!pq.isEmpty()) {
            // Get the vertex with the smallest known distance
            iPair current = pq.poll();
            int currentDist = current.first;
            int node = current.second;
            // Explore all adjacent vertices of the current node
            for (iPair edge : adj.get(node)) {
                int adjNode = edge.first;
                int edgeWeight = edge.second;
                // If a shorter path to adjNode is found, update its distance
                if (currentDist + edgeWeight < dist.get(adjNode)) {
                    dist.set(adjNode, currentDist + edgeWeight);
                    pq.add(new iPair(dist.get(adjNode), adjNode));
                }
            }
        }
        return dist;
    }
}

// Pair class to store (distance, vertex) pairs.
class iPair {
    int first, second;
    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
