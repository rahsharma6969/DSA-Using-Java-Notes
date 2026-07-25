/*
num = {1 ,2, 1}
sum = 2
output = [[1, 1], [2]]
 */


  
import java.util.ArrayList;
import java.util.List;

class Solution {

    public void printSubsequences(int[] nums, int index, int currentSum,
                                  int target, List<Integer> path,
                                  List<List<Integer>> result) {

        // Base case
        if (index == nums.length) {
            if (currentSum == target) {
                result.add(new ArrayList<>(path)); // Save a copy
            }
            return;
        }

        // Take the current element
        path.add(nums[index]);
        printSubsequences(nums, index + 1,
                currentSum + nums[index],
                target,
                path,
                result);

        // Backtrack
        path.remove(path.size() - 1);

        // Don't take the current element
        printSubsequences(nums, index + 1,
                currentSum,
                target,
                path,
                result);
    }
}

public class PrintSubSequenceSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int target = 2;

        Solution sol = new Solution();

        List<List<Integer>> result = new ArrayList<>();

        sol.printSubsequences(nums, 0, 0, target,
                new ArrayList<>(), result);

        System.out.println(result);
    }
}