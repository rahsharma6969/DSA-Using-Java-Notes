
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
/* 226. Invert Binary Tree
Solved
Easy
Topics
premium lock icon
Companies
Given the root of a binary tree, invert the tree, and return its root.

*/

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null ) return null;
         

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}


public class InvertTree {
    public static void main(String[] args) {
        
    }
}
