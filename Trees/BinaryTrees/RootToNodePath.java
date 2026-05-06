/*
Input: Binary Tree: 1 2 3 4 5 -1 -1 -1 -1, Node: 7
Output: [1, 3, 7]
Explanation: The path from the root node (1) to the target node (7) is 1 -> 3 -> 7. Therefore, the output is [1, 3, 7].
*/


import java.util.ArrayList;
import java.util.List;

class RootPathTreeNode {
    int val;
    RootPathTreeNode left;
    RootPathTreeNode right;
    RootPathTreeNode(int x) { 
        val = x; 
    }
}   
class RootToNodePathSolution {
    public List<Integer> rootToNodePath(RootPathTreeNode root, int target) {
        List<Integer> path = new ArrayList<>();
        if (findPath(root, target, path)) {
            return path;
        }
        return new ArrayList<>(); // return empty list if target not found
    }

    private boolean findPath(RootPathTreeNode node, int target, List<Integer> path) {
        if (node == null) {
            return false;
        }
        
        // Add the current node's value to the path
        path.add(node.val);
        
        // Check if the current node is the target
        if (node.val == target) {
            return true;
        }
        
        // Recursively search in the left and right subtrees
        if (findPath(node.left, target, path) || findPath(node.right, target, path)) {
            return true;
        }
        
        // If the target is not found in either subtree, remove the current node from the path
        path.remove(path.size() - 1);
        return false;
    }
}
public class RootToNodePath {
    public static void main(String[] args) {
        RootToNodePathSolution solution = new RootToNodePathSolution();
        RootPathTreeNode root = new RootPathTreeNode(1);    
        root.left = new RootPathTreeNode(2);
        root.right = new RootPathTreeNode(3);
        root.left.left = new RootPathTreeNode(4);       
        root.left.right = new RootPathTreeNode(5);
        root.right.left = new RootPathTreeNode(6);  
        root.right.right = new RootPathTreeNode(7);
        int target = 7;
        List<Integer> path = solution.rootToNodePath(root, target);
        System.out.println(path); // Output: [1, 3, 7]
        
    }
}
