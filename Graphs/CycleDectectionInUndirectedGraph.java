import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

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



    public boolean isCycleUsingDFS(int V, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected graph
        }

        boolean[] visited = new boolean[V];

        // Step 2: Check each component
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true; // cycle found
                }
            }
        }
        return false; // no cycle
    }

    // Step 3: DFS Helper Function
    private boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj))
                    return true;
            } else if (neighbor != parent) {
                return true; // cycle found
            }
        }

        return false;
    }
}




public class CycleDectectionInUndirectedGraph {
    public static void main(String[] args) {

    }
}
