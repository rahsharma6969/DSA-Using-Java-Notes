import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int node;
    int parent;

    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

class Solution {
    
    public boolean checkforcycleUsingBFS(int src, int V, int[][] adj, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        visited[src] = true;

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int curr = pair.node;
            int parent = pair.parent;

            for (int neighbor : adj[curr]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(new Pair(neighbor, curr));
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, int[][] edges) {
        // Code here
        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (checkforcycleUsingBFS(i, V, edges, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int node, int parent,
                ArrayList<ArrayList<Integer>> adj,
                boolean[] vis)  {
        vis[node] = true;
        for(int neighbour : adj.get(node)) {
            if(!vis[neighbour]) {
                // backtracking step to check for cycle in the graph
                if(dfs(neighbour, node, adj, vis)) { 
                    return true;
                }
            } else if(neighbour != parent) {
                return true;
            }
        }
        return false;
    }

    // Using DFS 
    public boolean isCycleDFS(int V, int[][] edges) {
         // Create adjacency list
        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Convert edges to graph
        for(int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[V];

        // Check all components
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(dfs(i, -1, adj, vis)) {
                    return true;
                }
            }
        }

        return false;
    }
}



public class CycleDectectionInUndirectedGraph {
    public static void main(String[] args) {

    }
}
