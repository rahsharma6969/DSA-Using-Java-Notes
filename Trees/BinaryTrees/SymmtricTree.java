/*

Code
Testcase
Testcase
Test Result
101. Symmetric Tree
Solved
Easy
Topics
premium lock icon
Companies
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
       if( root == null ) return true;
        return isMirror(root.left , root.right);

    }

    private boolean isMirror(TreeNode left , TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null ) return false;

        if(left.val != right.val) return false;
        return isMirror(left.left ,right.right) && isMirror(left.right , right.left);
       
    }
}
public class SymmtricTree {
    public static void main(String[] args) {
        
    }
}
