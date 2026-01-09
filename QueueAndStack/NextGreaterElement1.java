import java.util.*;

/* 
496. Next Greater Element I
Easy
Topics
premium lock icon
Companies
The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
*/


class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {  // but time complexity is O(n*m)
        int [] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        Map<Integer, Integer> map = new HashMap<>();

        for(int i= 0; i< nums1.length;i++){  // time complexity O(n)
            map.put(i, nums1[i]);
        }

        for(int i =0; i< nums1.length;  i++){
            int val = map.get(i);
           for(int j=0; j<nums2.length; j++){
                if(nums2[j] == val){
                     for(int k = j+1; k< nums2.length; k++){
                          if(nums2[k] > val){
                            ans[i] = nums2[k];
                            break;
                          }
                     }
           }
        }
    }    
     return ans; 

    }

    // Optimized approach using stack
    public int[] nextGreaterElementOptimized(int[] nums1, int[] nums2){
        int n = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

       // we will find the next greater element for each element in nums2
       for(int i= 0; i< n; i++){

        while(!stack.isEmpty() && stack.peek() < nums2[i]){
            int top = stack.pop();
            map.put(top, nums2[i]);
        }
        stack.push(nums2[i]);
       }

         // for the remaining elements in the stack, there is no greater element
         while(!stack.isEmpty()){
            int top = stack.pop();
            map.put(top, -1);

    }

    int [] ans = new int[nums1.length];
    for(int i=0; i<nums1.length; i++){
       if(map.containsKey(nums1[i])){
        ans[i] = map.get(nums1[i]);
       } 
    }
    return ans;
   /// time complexity is O(n + m) where n and m are the lengths of nums1 and nums2 respectively
    }
}
    


public class NextGreaterElement1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.nextGreaterElementOptimized(new int[]{4,1,2}, new int[]{1,3,4,2});
        System.out.println(Arrays.toString(result));
        
    }
}
