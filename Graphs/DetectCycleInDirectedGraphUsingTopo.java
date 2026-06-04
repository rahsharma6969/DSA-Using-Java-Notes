

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // using kahn's algorithm
    public boolean isCyclic(int V,  int[][] edges) {

        int[] indegree = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

            for(int i=0; i<V; i++) {
                 for(int neighbour : adj.get(i)) {
                    indegree[neighbour]++;
                 }
            }
           Queue<Integer> q = new LinkedList<>();
            for(int i=0; i<V; i++) {
                 if(indegree[i] == 0 ) q.add(i);
            }

            int count = 0;
            while(!q.isEmpty()) {
                int node = q.poll();
                count++;
                for(int neighbour : adj.get(node)) {
                    indegree[neighbour]--;
                    if(indegree[neighbour] == 0) q.add(neighbour);
                }
            }

            if(count == V) return false;
            return true;
        
    }
}

public class DetectCycleInDirectedGraphUsingTopo {
    
}
