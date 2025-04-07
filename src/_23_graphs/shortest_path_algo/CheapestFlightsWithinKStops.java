package _23_graphs.shortest_path_algo;
//https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
import java.util.*;
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        Queue<Tuple> q = new LinkedList<>();
        //{stops,{node,dist}}
        q.add(new Tuple(0,src,0));
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;
        // E = flights.length
        while(!q.isEmpty()){
            Tuple it = q.peek();
            q.remove();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;
            if(stops > k) continue;
            for(Pair iter : adj.get(node)){
                int adjNode = iter.first;
                int edW = iter.second;
                if(cost + edW < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + edW;
                    q.add(new Tuple(stops + 1, adjNode, cost + edW));
                }
            }
        }
        if(dist[dst] == (int) 1e9) return -1;
        return dist[dst];
    }
}
class Tuple{
    int first, second, third;
    Tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}