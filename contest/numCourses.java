/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
 */


import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Populate the adjacency list with prerequisites
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(prerequisiteCourse).add(course);
        }

        // Create an array to store the state of each course
        // 0: not visited, 1: visiting, 2: visited
        int[] state = new int[numCourses];

        // Check for cycles in the graph
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (!dfs(i, graph, state)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int course, List<List<Integer>> graph, int[] state) {
        state[course] = 1; // Mark as visiting

        for (int nextCourse : graph.get(course)) {
            if (state[nextCourse] == 1) {
                return false; // Cycle detected
            }
            if (state[nextCourse] == 0) {
                if (!dfs(nextCourse, graph, state)) {
                    return false;
                }
            }
        }

        state[course] = 2; // Mark as visited
        return true;
    }
}