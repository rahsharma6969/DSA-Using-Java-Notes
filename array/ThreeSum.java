
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 15. 3Sum

// Medium
// Topics

// Hint
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

 

// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.


class Solution{
   public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
       Arrays.sort(nums);
       int n = nums.length;
       
       // Iterate through the array, fixing one element at a time
       for(int i = 0; i < n - 2; i++){
           // Skip duplicate elements for  
           if(i > 0 && nums[i] == nums[i-1]) continue;
           
           // Optimization: if the current element is positive, no triplet can sum to 0
           if(nums[i] > 0) break;
           
           int left = i + 1;
           int right = n - 1;
           
           // Two-pointer approach to find pairs that sum to -nums[i]
           while(left < right){
               int sum = nums[i] + nums[left] + nums[right];
               if(sum == 0){
                   result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                   
                   // Skip duplicates for left pointer
                   while(left < right && nums[left] == nums[left+1]){
                       left++;
                   }
                   // Skip duplicates for right pointer
                   while(left < right && nums[right] == nums[right-1]){
                       right--;
                   }
                   
                   left++;
                   right--;
               } else if(sum < 0){
                   left++;      // Need larger sum, move left pointer right
               } else {
                   right--;     // Need smaller sum, move right pointer left
               }
           }
       }
       
       return result;
   }
}


// Time Complextiy : O(n^2)

public class ThreeSum {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> triplets = solution.threeSum(nums);
    System.out.println("Unique triplets that sum to zero: " + triplets);
  }
    
}
