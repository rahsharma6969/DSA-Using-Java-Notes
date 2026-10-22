/*
26. Remove Duplicates from Sorted Array
Easy

Hint
Given an integer array nums sorted in non-decreasing order,
 remove the duplicates in-place such that each unique element appears only once. 
 The relative order of the elements should be kept the same.

Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​. After removing duplicates, return the number of unique elements k.

The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 */

import java.util.LinkedHashSet;
import java.util.Set;

class Solutions {
    // Using two pointers to remove duplicates
    // time complexity: O(n)
    // space complexity: O(1)
    public int removeDuplicates(int[] nums) {
       int slow = 0;

       for(int fast = 0; fast<nums.length; fast++) {
        if(nums[slow] != nums[fast]) {
            slow++;
            nums[slow] = nums[fast];
        }
       }
       return slow + 1;
    }
    // Using LinkedHashSet to remove duplicates
    // time complexity: O(n)
    // space complexity: O(n)
    public int removeDuplicate(int[] nums) {
    Set<Integer> set = new LinkedHashSet<>();

    for (int num : nums) {
        set.add(num);
    }

    int i = 0;
    for (int num : set) {
        nums[i] = num;
        i++;
    } 
    return set.size();
}


}

public class RemoveDuplicate {
    public static void main(String[] args) {

        Solutions sol = new Solutions();
        int[] nums = { 1, 1, 2, 2, 3, 4, 4, 5 };
        int k = sol.removeDuplicates(nums);
        System.out.print(k + " ");
    }
}
