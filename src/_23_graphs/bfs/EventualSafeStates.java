package _23_graphs.bfs;
//https://leetcode.com/problems/find-eventual-safe-states/description/
import java.util.*;

public class EventualSafeStates {
    List<Integer> eventualSafeStates(int v, List<List<Integer>> adj){
        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i = 0; i < v; i++){
                adjRev.add(new ArrayList<>());
        }
        int[] indegree = new int[v];
        for(int i = 0; i < v; i++){
            for(int it : adj.get(i)){
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeStates = new ArrayList<>();
        for(int i = 0; i < v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            safeStates.add(node);
            for(int it : adjRev.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        Collections.sort(safeStates);
        return safeStates;
    }
}
