
class Solution{
    // brute force approach to move all zeros to end of array
    // time complexity: O(n^2)
    // space complexity: O(1)
    public void moveZeroes(int[] nums){
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                //swap with next non-zero element
                for(int j=i+1; j<nums.length; j++){
                    if(nums[j] !=0){
                        //swap
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    // optimal approach using two pointers
    // time complexity: O(n)
    // space complexity: O(1)
    // using left pointer to track position of next non-zero element
    public void moveZeroesTwoPointers(int[] nums){
        
       int left=0;
       for(int i=0; i<nums.length;i++){
        if(nums[i] !=0){
            // swap
            int temp = nums[left];
            nums[left] = nums[i];
            nums[i] = temp;
            left++;
        }
       }
        
    }
}

public class Movezero {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {0,1,0,3,12};
        sol.moveZeroesTwoPointers(nums);
        for(int num : nums){
            System.out.print(num + " ");
        }
    }
}
