
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
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    // returns height of tree
    private int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        // update diameter at this node
        diameter = Math.max(diameter, left + right);

        // return height to parent
        return 1 + Math.max(left, right);
    }
}

/**
 *  // compare the heights of left and right subtrees and reuturn the maximum
    static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int diameterThroughRoot = leftHeight + rightHeight;
        
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        
        return Math.max(diameterThroughRoot, Math.max(leftDiameter, rightDiameter));
    }  
 */

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