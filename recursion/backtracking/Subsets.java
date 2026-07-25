
import java.util.ArrayList;
import java.util.List;

public class Subsets {
    // time complexity: O(n * 2^n)
    // space complexity: O(n * 2^n)

      static int  backtracking(int[] nums, int start, List<Integer> currentList, List<List<Integer>> resuList){
        resultList.add(new ArrayList<>(currentList));

        for (int i = start; i < nums.length; i++) {
            currentList.add(nums[i]);
            backtracking(nums, i + 1, currentList, resuList);
            currentList.remove(currentList.size() - 1);
        }
        return 0;
    }
     static List<List<Integer>> subsets(int[] nums){

        List<List<Integer>> resultList = new ArrayList<>();

        backtracking(nums, 0, new ArrayList<>(), resultList);

        return resultList;
     }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("Subsets: " + subsets(nums));
    }
}
