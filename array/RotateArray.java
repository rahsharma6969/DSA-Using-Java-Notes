/*189. Rotate Array
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */


import java.util.ArrayList;


class Solution{
     // time complexity: O(n)
    // space complexity: O(n)
     public void rotate(int[] nums, int k) {
        ArrayList<Integer> temp = new ArrayList<>();
        int n = nums.length;
        for (int i = n - k; i < n; i++) {
        temp.add(nums[i]);
    }
        for(int i=0;i<n-k; i++){
            temp.add(nums[i]);
        }
        for(int i=0;i<n;i++){
            nums[i] = temp.get(i);
        }
    }
}


public class RotateArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        sol.rotate(nums, k);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
