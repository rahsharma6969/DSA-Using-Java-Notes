import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;  
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    // using level order traversal and a boolean flag to keep track of the direction
    // of traversal for each level.
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>(); // edge case: if the tree is empty, we return an empty list.
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>(); // we use a queue to perform level order traversal of the tree.
        queue.add(root);
        boolean leftToRight = true; // this flag will help us determine the order of traversal for each level.


        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(); // this list will store the values of the nodes at the current
                                                     // level.
            // we iterate through all the nodes at the current level and add their values to
            // the level list in the correct order based on the leftToRight flag.
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val); // add to the beginning of the list for right-to-left traversal
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level);
            leftToRight = !leftToRight; // toggle the direction for the next level
        }
        return result;
    }
}

public class ZigZagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        List<List<Integer>> result = solution.zigzagLevelOrder(root);
        System.out.println(result); // Output: [[1], [3, 2], [4, 5, 6, 7]]
    }
}