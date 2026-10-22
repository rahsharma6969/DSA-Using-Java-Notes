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


class Solution{
     // time complexity: O(n)
    // space complexity: O(n)
    //  public void rotate(int[] nums, int k) {
    //     ArrayList<Integer> temp = new ArrayList<>();
    //     int n = nums.length;
    //     k = k % n; // Handle cases where k is larger than the array length
    //     for (int i = n - k; i < n; i++) {
    //         temp.add(nums[i]);
    //     }
    //     for (int i = 0; i < n - k; i++) {
    //         temp.add(nums[i]);
    //     }
    //     for(int i=0;i<n;i++){
    //         nums[i] = temp.get(i);
    //     }
    // }

    public void reverse(int[] nums , int start , int end) {
        while(start < end) {
            int temp  = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n; // Handle cases where k is larger than the array length

        reverse(nums , 0 , n - 1);
        reverse(nums , 0 , k-1);
        reverse(nums , k , n - 1);
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
