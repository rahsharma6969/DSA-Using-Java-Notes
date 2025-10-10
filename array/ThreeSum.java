
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

// 15. 3Sum
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

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
        Arrays.sort(nums); // Sort the array to use two-pointer technique


        for(int i = 0; i< nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates for the first element
            int low = i+1;
            int high = nums.length - 1;

            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                if(sum < 0){
                    low++;
                }
                else if(sum > 0){
                    high--;
                }
                else{
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(low < high && nums[low] == nums[low + 1]) low++; // Skip duplicates
                    while(low < high && nums[high] == nums[high - 1]) high--; // Skip duplicates
                    low++;
                    high--;
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
