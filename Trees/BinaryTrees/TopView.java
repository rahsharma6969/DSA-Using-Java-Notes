import com.sun.source.tree.Tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

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
    static class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) return ans;
        
        Queue<Pair> p = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        p.add(new Pair(root, 0));

        while (!p.isEmpty()) {
            Pair curr = p.poll();
            if (!map.containsKey(curr.hd)) map.put(curr.hd, curr.node.val);

            if (curr.node.left != null) p.add(new Pair(curr.node.left, curr.hd - 1));
            if (curr.node.right != null) p.add(new Pair(curr.node.right, curr.hd + 1));
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) { 
            ans.add(entry.getValue());
        }
        return ans;
    }
}



public class TopView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        
    }
}
