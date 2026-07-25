/*
Given the root of a binary tree, the depth of each node is the shortest distance to the root.

Return the smallest subtree such that it contains all the deepest nodes in the original tree.

A node is called the deepest if it has the largest depth possible among any node in the entire tree.

The subtree of a node is a tree consisting of that node, plus the set of all descendants of that node.

 

Example 1:
*/
class Solution {

    int maxDepth = 0;
    TreeNode ans = null;


    public int dfs(TreeNode root, int depth) {

        if(root == null) {
            return depth;
        }


        int left = dfs(root.left, depth + 1);
        int right = dfs(root.right, depth + 1);


        if(left == maxDepth && right == maxDepth) {
            ans = root;
        }


        maxDepth = Math.max(maxDepth, Math.max(left, right));


        return Math.max(left, right);
    }


    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        dfs(root, 0);

        return ans;
    }
}

public class DepestNode {
    
}
