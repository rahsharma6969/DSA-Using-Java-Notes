/*80. Remove Duplicates from Sorted Array II
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

 */
class  Solution {
  public int removeDuplicates(int[] nums) {
          
     if(nums.length <=2) return nums.length;

     int k= 2;
     for(int i=k+1;i<nums.length;i++){
        if(nums[i] != nums[k-2]){
            nums[k] = nums[i];
            k++;
        }

     }
        return k;
    }
}
public class RemoveDuplicate2 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 1, 1, 2, 2,
                3, 4, 4, 5 };
        int k = sol.removeDuplicate(nums);  
        System.out.print(k + " ");

    }
}
