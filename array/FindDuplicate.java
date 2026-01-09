import java.util.HashSet;


class Solutions {
    // Using HashSet to find duplicate
    // time complexity: O(n)
    // space complexity: O(n)

     public int findDuplicate(int[] nums) {
       HashSet<Integer> seen = new HashSet<>();
       
       for(int num : nums){
        if(seen.contains(num)){
            return num;
        }
        seen.add(num);
       }
       return -1;
    }

    
}

public class FindDuplicate {
    public static void main(String[] args) {
        Solutions sol = new Solutions();
        int[] nums = {1,2,3,4,1};
        int result = sol.findDuplicate(nums);
        System.out.print(result + " ");
    }
}
        
