/* 
31. Next Permutation
Medium
Topics
premium lock icon
Companies
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]

*/

import java.util.*;

class Solution {

    List<List<Integer>> permutations = new ArrayList<>();

     boolean same(List<Integer> list, int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            if (list.get(i) != nums[i])
                return false;
        }

        return true;
    }

    void reverse(int[] nums) {

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }

    // Generate all permutations
    void generate(int[] nums, boolean[] used, List<Integer> current) {

        if (current.size() == nums.length) {
            permutations.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i])
                continue;

            // choose
            used[i] = true;
            current.add(nums[i]);

            // explore
            generate(nums, used, current);

            // undo
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    public void nextPermutation(int[] nums) {

        boolean[] used = new boolean[nums.length];

        generate(nums, used, new ArrayList<>());

        // Find current permutation
        int index = -1;

        for (int i = 0; i < permutations.size(); i++) {

            if (same(permutations.get(i), nums)) {
                index = i;
                break;
            }
        }

        // If current is last permutation
        if (index == permutations.size() - 1) {
            reverse(nums);
            return;
        }

        // Get next permutation
        List<Integer> next = permutations.get(index + 1);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = next.get(i);
        }
    }

   
}

// optimal
class Solution1 {

    public void nextPermutation(int[] nums) {

        int n = nums.length;

        // 1. Find pivot
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 2. Find smallest number greater than pivot
        if (i >= 0) {

            int j = n - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            swap(nums, i, j);
        }

        // 3. Make suffix smallest
        reverse(nums, i + 1, n - 1);
    }

    void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int[] nums, int i, int j) {

        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}

public class nextPermutation {
    public static void main(String[] args) {

    }
}