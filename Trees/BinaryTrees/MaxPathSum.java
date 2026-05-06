
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


class Solution {
    int maxSum = Integer.MIN_VALUE;
// time complexity: O(n) where n is the number of nodes in the tree, as we visit each node once.
// space complexity: O(h) where h is the height of the tree, due to the
    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return maxSum;
    }

    private int findMaxPath(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, findMaxPath(node.left)); // if the left path sum is negative, we ignore it by taking max with 0
        int right = Math.max(0, findMaxPath(node.right));// similarly for the right path sum

        maxSum = Math.max(maxSum, left + right + node.val); // backtracking step to update the maxSum with the current path sum 
        // because we are returning the max path sum for the current node, we can only choose one path (either left or right) 
    

        return node.val + Math.max(left, right);// to continue the path upwards
    }
}




   
    

public class MaxPathSum {
    
}
