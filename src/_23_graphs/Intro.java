package _23_graphs;

import java.util.ArrayList;

class Edge {
    int destination;
    int weight;

    // Constructor to create an edge with destination and weight
    Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

public class Intro {
    public static void main(String[] args) {
        int nodes = 3;
        int edges = 3;

        // ----------------------------------------
        // Code for Undirected Graph
        // ----------------------------------------
        // Creating adjacency list for the undirected graph
        ArrayList<ArrayList<Integer>> adjUndirected = new ArrayList<>();

        // Initializing the list for each node
        for (int i = 0; i <= nodes; i++) {
            adjUndirected.add(new ArrayList<Integer>());
        }

        // Adding edges for an undirected graph
        // Edge 1-2 (undirected)
        adjUndirected.get(1).add(2);
        adjUndirected.get(2).add(1);
        // Edge 2-3 (undirected)
        adjUndirected.get(2).add(3);
        adjUndirected.get(3).add(2);
        // Edge 1-3 (undirected)
        adjUndirected.get(1).add(3);
        adjUndirected.get(3).add(1);

        // Printing all the connected edges in the undirected graph
        System.out.println("Undirected Graph:");
        for (int i = 1; i <= nodes; i++) {
            System.out.print("Node " + i + " is connected to: ");
            for (int neighbor : adjUndirected.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

        System.out.println();

        // ----------------------------------------
        // Code for Directed and Weighted Graph
        // ----------------------------------------
        // Creating adjacency list for the directed and weighted graph
        ArrayList<ArrayList<Edge>> adjDirectedWeighted = new ArrayList<>();

        // Initializing the list for each node
        for (int i = 0; i <= nodes; i++) {
            adjDirectedWeighted.add(new ArrayList<Edge>());
        }

        // Directed and Weighted edges
        // Edge 1 -> 2 with weight 10
        adjDirectedWeighted.get(1).add(new Edge(2, 10));
        // Edge 2 -> 3 with weight 5
        adjDirectedWeighted.get(2).add(new Edge(3, 5));
        // Edge 1 -> 3 with weight 7
        adjDirectedWeighted.get(1).add(new Edge(3, 7));

        // Printing all the connected edges in the directed and weighted graph
        System.out.println("Directed and Weighted Graph:");
        for (int i = 1; i <= nodes; i++) {
            System.out.print("Node " + i + " is connected to: ");
            for (Edge e : adjDirectedWeighted.get(i)) {
                System.out.print("(" + e.destination + ", weight: " + e.weight + ") ");
            }
            System.out.println();
        }
    }
}
