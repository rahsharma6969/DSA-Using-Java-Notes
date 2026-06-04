import java.util.*;
import java.util.LinkedList;
import java.util.Queue;


class Node {
    int data;
    List<Node> neighbors;

    public Node(int data) {
        this.data = data;
        this.neighbors = new ArrayList<>();
    }
}

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();

        q.add(0); // starting BFS from node 0
        visited[0] = true;

        while(!q.isEmpty()) {
            int node  = q.poll();
            bfs.add(node);
            for(int neighbour : adj.get(node)) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
        return bfs;
    }
}

public class BFS {
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

        // Perform BFS starting from node1
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(2, 3))); // Neighbors of node1
        adj.add(new ArrayList<>(Arrays.asList(4)));    // Neighbors of node2
        adj.add(new ArrayList<>(Arrays.asList(4)));    // Neighbors of node3
        adj.add(new ArrayList<>());                     // Neighbors of node4
        ArrayList<Integer> result = solution.bfs(adj);
        System.out.println(result);
    }

    
}
