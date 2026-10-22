package array;
/*Majority Element-II
Subscribe to TUF+

Hints
Company
Given an integer array nums of size n. Return all elements which appear more than n/3 times in the array. The output can be returned in any order.


Example 1

Input: nums = [1, 2, 1, 1, 3, 2]

Output: [1]

Explanation:

Here, n / 3 = 6 / 3 = 2.

Therefore the elements appearing 3 or more times is : [1]

Example 2

Input: nums = [1, 2, 1, 1, 3, 2, 2]

Output: [1, 2]

Explanation:

Here, n / 3 = 7 / 3 = 2.

Therefore the elements appearing 3 or more times is : [1, 2]
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> majorityElementTwo(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;
        int threshold =  n / 3;
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : nums) {
          if(map.get(num) > threshold && !ans.contains(num)) ans.add(num);
        }

        return ans;
    }
}
public class MajorityElementII {
    
}
