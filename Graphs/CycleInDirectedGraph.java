
/*
Directed Graph Cycle
Difficulty: MediumAccuracy: 27.88%Submissions: 582K+Points: 4
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
The graph is represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge from vertex u to v.

Examples:

Input: V = 4, edges[][] = [[0, 1], [1, 2], [2, 0], [2, 3]]



Output: true
Explanation: The diagram clearly shows a cycle 0 → 1 → 2 → 0
Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]


Output: false
Explanation: no cycle in the graph


*/



import java.util.ArrayList;
import java.util.List;

class Solution {

    private boolean dfs(int node,
                        boolean[] vis,
                        boolean[] pathVis,
                        ArrayList<ArrayList<Integer>> adj) {

        vis[node] = true;

        pathVis[node] = true;

        for(int neighbour : adj.get(node)) {

            if(!vis[neighbour]) {

                if(dfs(neighbour, vis, pathVis, adj)) {

                    return true;
                }
            }

            else if(pathVis[neighbour]) {

                return true;
            }
        }

        // Backtracking
        pathVis[node] = false;

        return false;
    }

    public boolean isCyclic(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for(int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        boolean[] vis = new boolean[V];

        boolean[] pathVis = new boolean[V];

        for(int i = 0; i < V; i++) {

            if(!vis[i]) {

                if(dfs(i, vis, pathVis, adj)) {

                    return true;
                }
            }
        }

        return false;
    }
}

public class CycleInDirectedGraph {
    public static void main(String[] args) {
        
    }
}
