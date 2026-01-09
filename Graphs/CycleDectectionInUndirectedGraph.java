import java.lang.reflect.Array;
import java.util.ArrayList; 

class Graph {
    
    private ArrayList<Integer>[] adjList;  // adjacency list representation of graph

    public Graph() {
        this(10);
    }

    
    public Graph(int vertices){
        adjList = new ArrayList[vertices]; // create array of arraylists 
        for(int j=0; j<vertices; j++){
            adjList[j] = new ArrayList<Integer>();
        }
    }

    void addEdge(int src, int dest){
        // add undirected edge src <-> dest
        adjList[src].add(dest);
        adjList[dest].add(src);
    } 

   boolean isCycleUndirectedDfs(boolean visited[], int curr ,int parent){

        visited[curr] = true;
        for(int neighbor : adjList[curr]){
            if(!visited[neighbor]){
                if(isCycleUndirectedDfs(visited, neighbor, curr)){
                    return true;
                }
            }
            else if(neighbor != parent){ // this means that neightbor is already visited and is not parent of current node
                return true;
            }
        }

        return false;  
    }
}
public class CycleDectectionInUndirectedGraph {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0); // This edge creates a cycle
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        boolean visited[] = new boolean[5];
        boolean hasCycle = false;
        for(int i=0; i<5; i++){
            if(!visited[i]){
                if(graph.isCycleUndirectedDfs(visited, i, -1)){
                    hasCycle = true;
                    break;
                }
            }
        }
        if(hasCycle){
            System.out.println("Graph contains cycle");
        }
        else{
            System.out.println("Graph does not contain cycle");
        }

        
    }
}
