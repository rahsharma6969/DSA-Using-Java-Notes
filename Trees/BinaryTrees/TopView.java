import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.*;


class Pair {
    TreeNode node;
    int hd;

    public Pair(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}
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
    public static ArrayList<Integer> topView( TreeNode root) {
        ArrayList<Integer> ans  = new ArrayList<>();

        if(root == null) return ans;
        
        Queue<Pair> p = new LinkedList<Pair>();
        Map<Integer,Integer> map = new TreeMap<>();

        p.add(new Pair(root,0));

        while(!p.isEmpty()) {
        Pair curr = p.poll();
        if(!map.containsKey(curr)) map.put(curr.hd, curr.node.val);

        if(curr.left != null) p.add(new Pair(curr.left, curr.hd - 1));
        if(curr.right != null) p.add(new Pair(curr.right, curr.hd + 1));
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()) { 
            ans.add(entry.getValue());
        }
        return ans;
    }
}



public class TopView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        System.out.println(Solution.topView(root));
    }
}
