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
        int[] result = new int[n];
        int left = 0 , right = n - 1;
        for(int i=0;i<n;i++){
            if(Math.abs(nums[left] * nums[left]) > Math.abs(nums[right] * nums[right])){
                result[n - 1 - i] = nums[left] * nums[left];
                left++;
           
        } 
        else{
                result[n - 1 - i] = nums[right] * nums[right];
                right--;
        }
        
        
        }
        return result;

        
    }
}
public class SquareOfSortedArr {
    public static void main(String[] args) {
        
    }
}
