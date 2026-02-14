/*
problem number 977. Squares of a Sorted Array

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100] */
import java.util.Arrays;
class Solutin {
    // time complexity: O(n log n)
    // space complexity: O(1)
    public int[] sortedSquares(int[] nums) {
       for(int i=0;i<nums.length;i++){
        nums[i] = nums[i] * nums[i];
       } // time complexity: O(n)
       

       Arrays.sort(nums); // time complexity: O(n log n)

        return nums;
    }

    // time complexity: O(n)
    // space complexity: O(n)
    public int[] sortedSquaresTwoPointers(int[] nums){
        int n = nums.length;

        for(int i=0;i<n;i++){
            nums[i] = nums[i] * nums[i];
        } 

        
        int result[] = new int[nums.length];

        int left = 0;
        int right = n - 1;
        // we will fill the result array from the end to the beginning
        while(left <= right){
            if(nums[left] > nums[right]){
                result[n-1] = nums[left];
                left++;
                n--;

            }
            else{
                result[n-1] = nums[right];
                right--;
                n--;

            }
        }
        return result;

        
    }
}
public class SquareOfSortedArr {
    public static void main(String[] args) {
        
    }
}
