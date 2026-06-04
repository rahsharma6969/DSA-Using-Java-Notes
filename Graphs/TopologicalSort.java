import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
class Solution {

    private void dfs(int node,
            ArrayList<ArrayList<Integer>> adj,
            boolean[] vis,
            Stack<Integer> st) {

        vis[node] = true;

        for (int neighbour : adj.get(node)) {

            if (!vis[neighbour]) {

                dfs(neighbour, adj, vis, st);
            }
        }

        // Push after DFS
        st.push(node);
    }

    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];

        Stack<Integer> st = new Stack<>();

        // Handle disconnected components
        for (int i = 0; i < V; i++) {

            if (!vis[i]) {

                dfs(i, adj, vis, st);
            }
        }

        int[] ans = new int[V];

        int index = 0;

        while (!st.isEmpty()) {

            ans[index++] = st.pop();
        }

        return ans;
    }

    // using kahns algorithm OR bfs
    public int[] topoSortKahns(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[V];

        // cal indegree

        for (int i = 0; i < V; i++) {
            for (int neightbour : adj.get(i)) {
                indegree[neightbour]++;

            }
        }

        // push onde with indegree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // bfs
        int[] ans = new int[V];
        int index = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            ans[index++] = node;
            for (int neighbour : adj.get(node)) {
                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        return ans;

    }
}

public class TopologicalSort {

    public static void main(String[] args) {

    }
}
