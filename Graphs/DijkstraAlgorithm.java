// ...existing code...
import java.util.ArrayList; 
import java.util.*;


class Pair {
    int vertex;
    int weight;
    
    Pair(int v, int w) {
        this.vertex = v;
        this.weight = w;
    }
}

class Graph {
    
    private ArrayList<Pair>[] adjList;  // adjacency list representation of graph with weights

    public Graph() {
        this(10);
    }

    
    public Graph(int vertices){
        adjList = new ArrayList[vertices]; // create array of arraylists 
        for(int j=0; j<vertices; j++){
            adjList[j] = new ArrayList<Pair>();
        }
    }

    void addEdge(int src, int dest, int weight){
        // add directed edge src -> dest with given weight
        adjList[src].add(new Pair(dest, weight));
    } 

    // Dijkstra's algorithm from source src; returns array of shortest distances
    int[] dijkstra(int src) {
        int V = adjList.length;
        final int INF = Integer.MAX_VALUE;
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.vertex;
            int d = cur.weight;

            // stale entry check
            if (d > dist[u]) continue;

            for (Pair edge : adjList[u]) {
                int v = edge.vertex;
                int w = edge.weight;
                if (dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }
}
// ...existing code...
public class DijkstraAlgorithm {
    
    

    public static void main(String[] args) {
        System.out.println("Dijkstra's Algorithm implementation");
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 1, 4);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 4, 7);
        graph.addEdge(4, 3, 9);

        int[] dist = graph.dijkstra(0);
        System.out.println("Shortest distances from source 0: " + Arrays.toString(dist));
        // Expected output: [0, 7, 3, 9, 5] (for the given graph)
        // Note: unreachable nodes would be Integer.MAX_VALUE
    }
}