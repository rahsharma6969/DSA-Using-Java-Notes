/*/**
Reverse Pairs
Subscribe to TUF+

Hints
Company
Given an integer array nums. Return the number of reverse pairs in the array.



An index pair (i, j) is called a reverse pair if:



0 <= i < j < nums.length


nums[i] > 2 * nums[j]

Example 1

Input: nums = [6, 4, 1, 2, 7]

Output: 3

Explanation:

The reverse pairs are:

(0, 2) : nums[0] = 6, nums[2] = 1, 6 > 2 * 1

(0, 3) : nums[0] = 6, nums[3] = 2, 6 > 2 * 2

(1, 2) : nums[1] = 4, nums[2] = 1, 4 > 2 * 1

Example 2

Input: nums = [5, 4, 4, 3, 3]

Output: 0

Explanation:

No pairs satisfy both the conditons.
 */

class Solution {

    // Brute Force Approach
    // time complexity: O(n^2)
    // space complexity: O(1)
    public int reversePairs(int[] nums) {

        int n = nums.length;
        int count = 0;

        for(int i = 0; i< n; i++) {
            for(int j = i+1; j<n; j++) {
                if(nums[i] > 2 * nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }

   
}

class Solution1 {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;

        int count = 0;
        count += mergeSort(nums, left, mid);
        count += mergeSort(nums, mid + 1, right);
        count += countAndMerge(nums, left, mid, right);

        return count;
    }

    private int countAndMerge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int count = 0;

        // Count reverse pairs: nums[i] > 2 * nums[j]
        while (i <= mid && j <= right) {
            if ((long) nums[i] > 2L * nums[j]) {
                count += (mid - i + 1);
                j++;
            } else {
                i++;
            }
        }

        i = left;
        j = mid + 1;

        // Merge the two sorted halves
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        for (int idx = 0; idx < temp.length; idx++) {
            nums[left + idx] = temp[idx];
        }

        return count;
    }
}
 


public class ReversePair {
    
}
