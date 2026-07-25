/*
Power Set
Subscribe to TUF+

Hints
Company
Given an array of integers nums of unique elements. 
Return all possible subsets (power set) of the array.



Do not include the duplicates in the answer.


Example 1

Input : nums = [1, 2, 3]

Output : [ [ ] , [1] , [2] , [1, 2] , [3] , [1, 3] , [2, 3] , [1, 2 ,3] ]

Example 2

Input : nums = [1, 2]

Output : [ [ ] , [1] , [2] , [1,2] ] */


import java.util.ArrayList;
import java.util.List;

class Solution {

    // pick and not pick approach
    public void helper(int[] nums , int index , List<Integer> path , List<List<Integer>> result) {
        if(index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        helper(nums, index + 1, path , result); // pick the element
        path.remove(path.size() - 1); // backtrack
        helper(nums, index + 1, path , result); // not pick the element
    }
    public List<List<Integer>> powerSet(int[] nums) {
        //your code goes here
        List<List<Integer>> result = new ArrayList<>();
        helper(nums , 0 , new ArrayList<>() , result);
        return result;
    }
}



public class powerSet {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Solution sol = new Solution();
        List<List<Integer>> result = sol.powerSet(nums);

        System.out.println(result);
        
    }
}
