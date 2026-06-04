import java.util.ArrayList;
import java.util.List;
import java.util.*;

class UndirectedGraph {
    public List<List<Integer>> UndirectedGraph(int m, int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(); // adjacency list representation of graph
        for(int i=0; i<m; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            int u = edges[i][0]; // source vertex
            int v = edges[i][1]; // destination vertex
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}
public class Graph {
    // using ArrayList to represent graph
    
    public static void main(String[] args) {
        System.out.println("Hello World");
        UndirectedGraph ug = new UndirectedGraph();
        int V = 5, E = 4;
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {2, 4}};
        List<List<Integer>> graph = ug.UndirectedGraph(V, E, edges);
        for(int i=0; i<graph.size(); i++){
            System.out.print(i + " -> ");
            for(int j=0; j<graph.get(i).size(); j++){
                System.out.print(graph.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}