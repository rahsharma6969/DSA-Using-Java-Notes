/* 
Find the repeating and missing number
Subscribe to TUF+

Hints
Company
Given an integer array nums of size n containing values from [1, n] and
each value appears exactly once in the array, except for A, 
which appears twice and B which is missing.



Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.



Note: You are not allowed to modify the original array.


Example 1

Input: nums = [3, 5, 4, 1, 1]

Output: [1, 2]

Explanation:

1 appears two times in the array and 2 is missing from nums

Example 2

Input: nums = [1, 2, 3, 6, 7, 5, 7]

Output: [7, 4]

Explanation:

7 appears two times in the array and 4 is missing from nums.

*/
import java.util.*;


class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
       int n = nums.length;
       int[] ans = new int[2];

       Set<Integer> seen = new HashSet<>();
       for (int num : nums) {
        if(seen.contains(num)){
            ans[0] = num; // Repeating number
        }
        seen.add(num);
       }


       for (int i = 1; i <= n; i++) {
        if(!seen.contains(i)){ // why this: bez we are checking for missing number, if the number is not present in the set then it is missing
            ans[1] = i; // Missing number
            break;
        }
       }

        return ans;
        }
    }


public class MissingAndRepeating {
    
}
