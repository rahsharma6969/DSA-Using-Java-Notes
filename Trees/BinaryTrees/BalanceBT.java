

public class BalanceBT {
    
    int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
    boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);

    }

    // time complexity: O(n^2)
    // space complexity: O(h) where h is height of tree
    public static void main(String[] args) {
        System.out.println("Balance Binary Tree Check");
    }
}
