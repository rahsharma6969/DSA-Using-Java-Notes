/*
90. Subsets II
Medium
Topics
premium lock icon
Companies
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public void backtrack(int[] nums , int index , List<Integer> path , 
        List<List<Integer>> result) {
            
            result.add(new ArrayList<>(path));
            
            for(int i = index ; i < nums.length ; i++) {
                if( i > index && nums[i] == nums[i - 1]) {
                    continue;
                }

                path.add(nums[i]);
                backtrack(nums , i + 1 , path , result);
                path.remove(path.size() - 1);
            }
        }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums , 0 , new ArrayList<>(), result);
        return result;
    }
}



public class SubsetSum2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets = solution.subsetsWithDup(nums);
        System.out.println(subsets);
    }
}
