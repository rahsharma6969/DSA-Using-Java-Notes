import java.util.HashMap;
import java.util.Map;

class Solution {
     // time complexity: O(n)
      // space complexity: O(n)
    public int SingleNumber(int [] nums) {
        int singleNumber = 0;
         Map<Integer, Integer> map = new HashMap<>();
         for(int num : nums){ // O(n)
            map.put(num, map.getOrDefault(num, 0) + 1);
         }

         for( int num: nums){  // O(n)
            if(map.get(num) == 1){
                singleNumber = num;
                break;
            }
         }
            return singleNumber;

    }

    
}

public class SingleNumber {
    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] nums = {4,1,2,1,2};
        int result = sol.SingleNumber(nums);
        System.out.println("The single number is: " + result);
        
    }
}
