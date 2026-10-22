
/*
Frog Jump with K Jump
jumps are allowed till kth steps
and rest of the questions is same as frog jump

*/

class Solution {
    public  int helper(int idx , int[] heights, int k) {
        if(idx < 0 || idx == 0) return 0;
        if(idx == 1) return Math.abs(heights[1] - heights[0]);
         int jump = Integer.MAX_VALUE;
        for(int i =1; i<=k; i++) {
            if(idx - i >=0) {
               jump =Math.min(jump, helper(idx - i, heights , k) +
               Math.abs(heights[idx]- heights[idx-i]));
            
        } else {
            break;
        }
    }
       return jump;
        
    }

    public int frogJump(int[] heights, int k) {
        int n = heights.length;

        return helper(n - 1, heights,  k) ;
    }
}


public class FrogWithkJump {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] heights = {15, 4, 1, 14, 15};
        int k = 3;

        System.out.println(sol.frogJump(heights, k)); // Output: 40
    }
}
