

/*

238. Product of Array Except Self
Attempted
Medium

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

 */



class Solutions{
     // using brute force approach
     // time complexity: O(n^2)
     // space complexity: O(n)
     int[] productExceptSelf(int[] nums) {
          int result[] = new int[nums.length];

          for(int i=0;i<nums.length;i++){
            int product = 1;
            for(int j=0; j<nums.length;j++){
                if(i != j){
                    product *= nums[j];
                }
            }
            result[i] = product;
          }
            return result;
       
    }

    // optimized approach
    // time complexity: O(n)
    // space complexity: O(1) excluding output array
   

    int[] productExceptSelfOptimized( int[] nums){
        int n = nums.length;
        int[] result = new int[n];
    
             int[] prefixProducts = new int[n];
             int[] suffixProducts = new int[n];

             // Calculate prefix products
                prefixProducts[0] = 1;
                for (int i = 1; i < n; i++) {
                    prefixProducts[i] = prefixProducts[i - 1] * nums[i - 1];
                }

                // Calculate suffix products
                suffixProducts[n - 1] = 1;
                for (int i = n - 2; i >= 0; i--) {
                    suffixProducts[i] = suffixProducts[i + 1] * nums[i + 1];
                }

                // Calculate result
                for (int i = 0; i < n; i++) {
                    result[i] = prefixProducts[i] * suffixProducts[i];
                }
            
            return result;
        }
}

public class ProductOfArr {
    public static void main(String[] args) {
        Solutions sol = new Solutions();
        int[] nums = {1, 2, 3, 4};
        int[] result = sol.productExceptSelf(nums);
        System.out.print("Product of array except self: ");
        for(int i=0;i<result.length;i++){
            System.out.print(result[i] + " ");
        }
    }
}
