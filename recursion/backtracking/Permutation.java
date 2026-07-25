
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    void helper(int[] nums , int index , List<List<Integer>> result ,List<Integer> list, Map<Integer , Boolean> map) {
        // base case
        if(index == nums.length) {
            result.add(new ArrayList<>(list));
         }

         for(int i=0 ;i <nums.length ; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i] , true);
                list.add(nums[i]);
                helper(nums , index + 1 , result ,list , map);
                list.remove(list.size() - 1);
                map.remove(nums[i]);
            }
         }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer , Boolean> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        helper(nums , 0 , result ,list, map);
        return result;
    }
}

public class Permutation {
    public static void main(String[] args) {
        
    }
}