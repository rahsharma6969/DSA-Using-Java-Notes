/*
M-Coloring Problem
Difficulty: MediumAccuracy: 34.42%Submissions: 
198K+Points: 4Average Time: 45m
You are given an undirected graph consisting of V vertices and E edges
represented by a list edges[][], along with an integer m. 
Your task is to determine whether it is possible to color the graph 
using at most m different colors such that no two adjacent vertices 
share the same color. Return true if the graph can be colored with at
most m colors, otherwise return false.

Note: The graph is indexed with 0-based indexing.

Examples:

Input: V = 4, edges[][] = [[0, 1], [1, 3], [2, 3], [3, 0], [0, 2]], m = 3
Output: true
Explanation: It is possible to color the given graph using 3 colors, for example, one of the possible ways vertices can be colored as follows:
 */

class Solution {

    boolean isPossible(int node , int[][] edges , int[] color , int n , int col) {

        for(int i = 0; i<n ; i++) {

            if(edges[node][i] == 1 && color[i] == col) {
                return false;
            }
        }
        return true;
    }

    boolean solve(int node , int [][] edges , int[] color , int n , int m) {
        if(node == n) {
            return true;
        }

        for(int i=1; i<=m; i++) {

            if(isPossible(node , edges , color , n , i)) {
                color[node] = i;
                if(solve(node + 1 , edges , color , n , m)) {
                    return true;
                }
                color[node] = 0; // Backtrack
            }
        }
        return false;
    }
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        int[][] adj;
        if(edges.length == v && edges[0].length == v) {
            adj = edges; // already adjacency matrix
        } else {
            // edges is likely list of pairs -> convert to adjacency matrix
            adj = new int[v][v];
            for(int[] e : edges) {
                if(e.length >= 2) {
                    int a = e[0];
                    int b = e[1];
                    if(a >= 0 && a < v && b >= 0 && b < v) {
                        adj[a][b] = 1;
                        adj[b][a] = 1;
                    }
                }
            }
        }

        int[] color = new int[v];
        return solve(0, adj, color, v, m);
    }
}

public class MColor {
    public static void main(String[] args) {
        // Example 1: V = 4, edges list, m = 3 -> expected: true
        int v = 4;
        int[][] edgesList = new int[][] {
            {0, 1}, {1, 3}, {2, 3}, {3, 0}, {0, 2}
        };
        int m = 3;
        Solution sol = new Solution();
        boolean possible = sol.graphColoring(v, edgesList, m);
        System.out.println("Can color with " + m + " colors? " + possible);
        
        // Example 2: simple triangle, V=3, m=2 -> expected: false
        int v2 = 3;
        int[][] tri = new int[][] { {0,1}, {1,2}, {2,0} };
        System.out.println("Triangle with 2 colors? " + sol.graphColoring(v2, tri, 2));
    }
}