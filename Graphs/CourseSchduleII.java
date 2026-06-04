/*
210. Course Schedule II
Medium
Topics
premium lock icon
Companies
Hint
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
*/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // using topological sort to find the order of courses
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
         
        // creating the graph
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // adding the edges to the graph
        for(int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            for(int neighbor : graph.get(i)) {
                indegree[neighbor]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int current = queue.poll();
            ans.add(current);
            for(int neighbor : graph.get(current)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if(ans.size() != numCourses) {
            return new int[0];
        }
        int[] result = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}


public class CourseSchduleII {
    
}
