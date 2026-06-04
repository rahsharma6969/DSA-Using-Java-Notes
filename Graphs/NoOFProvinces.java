

class Solution {
    // using DFS to find number of provinces in a graph
    public void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;
        for(int j=0; j<isConnected.length; j++) {
            if(isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count =0;
        boolean[] visited = new boolean[isConnected.length];
        for(int i=0; i<isConnected.length; i++) {
            if(!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }
}


public class NoOFProvinces {
    
    public static void main(String[] args) {

    }
}
