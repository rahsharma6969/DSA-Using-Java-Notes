/*
3558. Number of Ways to Assign Edge Weights I
Medium
Topics
premium lock icon
Companies
Hint
There is an undirected tree with n nodes labeled from 1 to n, rooted at node 1. The tree is represented by a 2D integer array edges of length n - 1, where edges[i] = [ui, vi] indicates that there is an edge between nodes ui and vi.

Initially, all edges have a weight of 0. You must assign each edge a weight of either 1 or 2.

The cost of a path between any two nodes u and v is the total weight of all edges in the path connecting them.

Select any one node x at the maximum depth. Return the number of ways to assign edge weights in the path from node 1 to x such that its total cost is odd.

Since the answer may be large, return it modulo 109 + 7.

Note: Ignore all edges not in the path from node 1 to x.
 

Example 1:



Input: edges = [[1,2]]

Output: 1

Explanation:

The path from Node 1 to Node 2 consists of one edge (1 → 2).
Assigning weight 1 makes the cost odd, while 2 makes it even. Thus, the number of valid assignments is 1.
Example 2:



Input: edges = [[1,2],[1,3],[3,4],[3,5]]

Output: 2

Explanation:

The maximum depth is 2, with nodes 4 and 5 at the same depth. Either node can be selected for processing.
For example, the path from Node 1 to Node 4 consists of two edges (1 → 3 and 3 → 4).
Assigning weights (1,2) or (2,1) results in an odd cost. Thus, the number of valid assignments is 2. */

// step 0: convert edges to adj list
// step 1 : find the max depth and the node at max depth
// step 2 : find the number of edges in the path from root to node at max depth
// step 3 : if number of edges is even then return 2^(number of edges - 1)
//  else return 2^(number of edges - 1) * 2
import java.util.*;
class Solution {

    static final int MOD = 1000000007;

    int caldepth(ArrayList<ArrayList<Integer>> adj, int node, int depth, boolean[] visited) {
        visited[node] = true;
        int maxdepth = depth;

        for(int i : adj.get(node)) {
            if(!visited[i]) {
                maxdepth = Math.max(maxdepth, caldepth(adj, i, depth + 1, visited));
            }
        }
        return maxdepth;
    }

    long powmod(long base, int power) {
        long ans = 1;
        while(power > 0) {
            if((power & 1) == 1) {
                ans = (ans * base) % MOD;
            }
            base = (base * base) % MOD;
            power >>= 1;
        }
        return ans;
    }

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[n + 1];

        int maxDepth = caldepth(adj, 1, 0, visited);

        return (int) powmod(2, maxDepth - 1);
        
    }
}
public class NoOfWaysToAssignWeights {
    
}
