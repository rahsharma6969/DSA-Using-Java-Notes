/*128. Longest Consecutive Sequence
Medium
Topics
premium lock icon
Companies
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */

import java.util.HashSet;
class Solution{
    // HashSet + Greedy
    // time complexity: O(n)
    public int longestConsecutive(int[] nums) {
        int Longestlength = 0;
        HashSet<Integer> consecutiveSet = new HashSet<>();
        for(int num: nums){
            consecutiveSet.add(num);
        }
        for(int num: nums){
            // check if it's the start of a sequence
            if(!consecutiveSet.contains(num - 1)){
                int currentNum = num;
                int currentStreak = 1;

                while(consecutiveSet.contains(currentNum + 1)){
                    currentNum += 1;
                    currentStreak += 1;
                }

                Longestlength = Math.max(Longestlength, currentStreak);
            }
        }
       return Longestlength;
    }
}

public class LongestCOnsectutiveNumber {
    public static void main(String[] args) {
        
    }
}
