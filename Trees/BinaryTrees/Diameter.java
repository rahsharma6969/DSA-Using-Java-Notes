
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { 
        val = x; 
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int diameter = 0; // global variable to keep track of the diameter

   public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter; 
   }

   private int height(TreeNode root) {
    if(root == null) return 0;

    int left = height(root.left);
    int right = height(root.right);

    diameter = Math.max(left + right , diameter); // update diameter if the path through the current node is larger
    return 1 + Math.max(left , right); // for continuing the height calculation for parent nodes
   }

   
}


public class Diameter {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int result = sol.diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree: " + result);
    }
}