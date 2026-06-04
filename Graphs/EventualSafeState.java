/*
802. Find Eventual Safe States
Medium
Topics
premium lock icon
Companies
There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

 

Example 1:

Illustration of graph
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
Example 2:

Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
Output: [4]
Explanation:
Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;


class Solution {
     private boolean dfs(int node, int[][] graph, int[] color, int[] pathVis) {
        if (color[node] != 0) {
            return color[node] == 2;
        }

        color[node] = 1; // Mark as visiting
        pathVis[node] = 1; // Mark as in the current path

        for (int neighbor : graph[node]) {
            if (!dfs(neighbor, graph, color, pathVis)) {
                return false;
            }
        }

        color[node] = 2; // Mark as safe
        pathVis[node] = 0; // Mark as not in the current path
        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int n = graph.length;
        int[] color = new int[n]; 
        int[] pathVis = new int[n];

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, color , pathVis)) {
                result.add(i);
            }
        }

        return result;
    }

   
}

class Solutions {
    // using topological sort
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer>[] reverseGraph = new ArrayList[n];
        int[] outDegree = new int[n];

        for (int i = 0; i < n; i++) {
            reverseGraph[i] = new ArrayList<>();
            outDegree[i] = graph[i].length;
            for (int neighbor : graph[i]) {
                reverseGraph[neighbor].add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);
            for (int neighbor : reverseGraph[node]) {
                outDegree[neighbor]--;
                if (outDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}





public class EventualSafeState {
    
}
