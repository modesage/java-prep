package _23_graphs.mst_disjoint_set;
import java.util.*;
public class KruskalAlgo {
    int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        List<Edge> edges = new ArrayList<Edge>();
        //O(N + E)
        for(int i = 0; i < V; i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                int adjNode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);
                int node = 1;
                Edge temp = new Edge(i,adjNode,wt);
                edges.add(temp);
            }
        }
        DisjointSet ds = new DisjointSet(V);
        //M log M
        Collections.sort(edges);
        int mstWt = 0;
        //M * 4 * alpha * 2
        for(int i = 0; i < edges.size(); i++){
            int wt = edges.get(i).weight;
            int u = edges.get(i).src;
            int v = edges.get(i).dest;
            if(ds.findUltParent(u) != ds.findUltParent(v)){
                mstWt += wt;
                ds.unionBySize(u,v);
            }
        }
        return mstWt;
    }
}
class Edge implements Comparable<Edge>{
    int src, dest, weight;
    Edge(int src, int dest, int wt){
        this.src = src;
        this.dest = dest;
        this.weight = wt;
    }
    //Comparator method used for sorting edge, based on their weight
    public int compareTo(Edge compareEdge){
        return this.weight - compareEdge.weight;
    }
}