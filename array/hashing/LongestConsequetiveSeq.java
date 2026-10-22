/*
Longest Consecutive Sequence in an Array
Subscribe to TUF+

Hints
Company
Given an array nums of n integers.



Return the length of the longest sequence of consecutive integers. The integers in this sequence can appear in any order.


Example 1

Input: nums = [100, 4, 200, 1, 3, 2]

Output: 4

Explanation:

The longest sequence of consecutive elements in the array is [1, 2, 3, 4], which has a length of 4. This sequence can be formed regardless of the initial order of the elements in the array.

Example 2

Input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]

Output: 9

Explanation:

The longest sequence of consecutive elements in the array is [0, 1, 2, 3, 4, 5, 6, 7, 8], which has a length of 9. 
 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
    int longest = 0;
    Set<Integer> seen = new HashSet<>();
    
    for(int num : nums) {
        seen.add(num);
    }

    for(int num : seen) {
        if(!seen.contains(num - 1)) {
            int current = num;
            int length = 1;

            while(seen.contains(current + 1)) {
                current++;
                length++;
            }

            longest = Math.max(longest, length);
        }
    }

    return longest;
    }
}