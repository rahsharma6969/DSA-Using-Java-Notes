

import java.util.*;
import java.util.LinkedList;

public class Graph {
    
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

    void removeEdge(int src, int dest){
        // remove by object to avoid ambiguity with remove(index)
        adjList[src].remove(Integer.valueOf(dest));
        adjList[dest].remove(Integer.valueOf(src));
    }

    void printGraph(){
        for(int i = 0; i < adjList.length; i++){   /// traverse each index of adjacency list
            System.out.print(i + " -> ");
            for(int neighbor : adjList[i]){ // enhanced for loop to traverse adjacency list at each idx
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    void bfs(int startVertex){
        boolean visited[] = new boolean[adjList.length];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while(!queue.isEmpty()){
            int curr  = queue.poll();
            System.out.print(curr + " ");
            for (int neighbor : adjList[curr]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
    

    void dfsHelper(int vertex, boolean visited[]){
        visited[vertex]  = true;
        System.out.print(vertex + " ");

        for(int neighbour : adjList[vertex]){
            if(!visited[neighbour]){
                dfsHelper(neighbour, visited);
            }
        }
    }

    void dfs(int startVertex){
        boolean visited[] = new boolean[adjList.length];

        // start from the requested vertex, then cover any disconnected components
        if (!visited[startVertex]) {
            dfsHelper(startVertex, visited);
        }
        for(int i = 0; i < adjList.length; i++){
            if(!visited[i]){
                dfsHelper(i, visited);
            }
        }
        System.out.println();
    }

    
     // simple dfs logic to detect cycle in undirected graph
    boolean isCycleUndirectedDfsHelper(int vertex, boolean visited[], int parent){

        visited[vertex]  = true;

        for(int neighbour : adjList[vertex]){
            if(!visited[neighbour]){
                if(isCycleUndirectedDfsHelper(neighbour, visited, vertex)){
                    return true;
                }
            }
            else if(neighbour != parent){
                return true;
            }
        }

        return false;
    }

    boolean isCycleUndirectedDfs( int startVertex){
        boolean visited[] = new boolean[adjList.length];

        // start from the requested vertex, then cover any disconnected components
        if (!visited[startVertex]) {
            if(isCycleUndirectedDfsHelper(startVertex, visited, -1)){
                return true;
            }
        }
        for(int i = 0; i < adjList.length; i++){
            if(!visited[i]){
                if(isCycleUndirectedDfsHelper(i, visited, -1)){
                    return true;
                }
            }
        }
        return false;

    }
 
   public static void main(String[] args) {
       // example usage (optional)
       Graph g = new Graph(5);
       g.addEdge(0,1);
       g.addEdge(0,2);
       g.addEdge(1,3);
       g.addEdge(3,4);

       System.out.print("BFS from 0: ");
       g.bfs(0);

       System.out.print("DFS from 0: ");
       g.dfs(0);
   }
     
    }

