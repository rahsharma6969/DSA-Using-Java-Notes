/*Subset Sums
Difficulty: MediumAccuracy: 72.55% Submissions: 194K+Points: 4
Given an array arr of integers, return the sums of all subsets in the list.
Return the sums in any order.

Examples:

Input: arr[] = [2, 3]
Output: [0, 2, 3, 5]
Explanation: When no elements are taken then Sum = 0.
When only 2 is taken then Sum = 2. When only 3 is taken then Sum = 3.
 When elements 2 and 3 are taken then Sum = 2+3 = 5. 
 
 */
import java.util.ArrayList;
class Solution {
    public void helper(int[] arr , int index , int sum , ArrayList<Integer> result) {
        if(index == arr.length) {
            result.add(sum);
            return;
        }

        // pick 
        helper(arr, index + 1 , sum + arr[index] , result);

        // not pick 
        helper(arr, index + 1 , sum , result);
    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        helper(arr , 0 , 0 , result);
        return result;
    }
}




public class SubsetSumI {
    
}
