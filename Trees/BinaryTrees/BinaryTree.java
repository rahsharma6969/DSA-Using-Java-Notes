import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class BinaryTreeNode {
    BinaryTreeNode left;
    BinaryTreeNode right;
    int data;

    BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    // left -> root -> right
    void inOrderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    // root -> left -> right
    void preOrderTraversal(BinaryTreeNode root) {
        if (root == null ) return ;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    // left -> right -> root
    void postOrderTraversal(BinaryTreeNode root) {
        if (root == null ) return ;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
}
    

    ArrayList<Integer> levelOrderTraversal(BinaryTreeNode root) {
        if(root == null) return null;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
           root = queue.poll();
           list.add(root.data);
        //    System.out.print(root.data + " ");
           if(root.left != null) queue.add(root.left);
           if(root.right != null) queue.add(root.right);    
        }
        return list;
    }

     public int maxDepth(BinaryTreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left , right);
    }

    // balanced binary tree: a binary tree in which the difference between the heights of the left and right subtrees is no more than one for every node.
    public boolean isBalanced(BinaryTreeNode root) {
        if (root == null) return true;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
     boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q) { // using in-order traversal
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p == q) return true;
        if(p.data != q.data) return false;
        boolean left = isSameTree(p.left , q.left);
        boolean right  = isSameTree(p.right , q.right);

        return left && right;
       

    }
}
public class BinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);

        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);

        // root.inOrderTraversal(root);
        System.out.println(root.levelOrderTraversal(root));
    }
}
