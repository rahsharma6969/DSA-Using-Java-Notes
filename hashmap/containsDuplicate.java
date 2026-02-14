import java.util.HashSet;
import java.util.Set;

class Solution {

    // using HashSet
    // time complexity: O(n)
    // space complexity: O(n)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num: nums){
            if(!set.add(num)){ // if add returns false, it means the element is already present because Set does not allow duplicates
                return true;
            }
            set.add(num);
        }
        return false;
    }

    // using two pointers
    // time complexity: O(n^2)
    // space complexity: O(1)
    public boolean containsDuplicateTwoPointers(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
         return false;
    } 
}




public class containsDuplicate {
    public static void main(String[] args) {
          
    }
}
