import java.util.*;

class Node {
    int data;
    List<Node> neighbors;

    public Node(int data) {
        this.data = data;
        this.neighbors = new ArrayList<>();
    }
}
class Solution {
    public void dfshelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfs) {
        visited[node] = true;
        dfs.add(node);
        for(int neighbour : adj.get(node)) {
            if(!visited[neighbour]) {// this is important to avoid infinite loop in case of cycles in the graph
                dfshelper(neighbour, adj, visited, dfs);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        for(int i=0; i<adj.size(); i++) { // for disconnected graph, we need to call dfshelper for all unvisited nodes
            if(!visited[i]) {
                dfshelper(i, adj, visited, dfs);
            }
        }
        return dfs;
    }
}
public class DFS {

    public static void main(String[] args) {
        // Create a sample graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node4);
        node3.neighbors.add(node4);

        // Perform DFS starting from node1
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(2, 3))); // Neighbors of node1
        adj.add(new ArrayList<>(Arrays.asList(4)));    // Neighbors of node2
        adj.add(new ArrayList<>(Arrays.asList(4)));    // Neighbors of node3
        adj.add(new ArrayList<>());                     // Neighbors of node4
        ArrayList<Integer> result = solution.dfs(adj);
        System.out.println(result);
    }
    
}
