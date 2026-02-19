
import java.util.ArrayList;
import java.util.List;

public class SubsetsofArr {
   // time complexity: O(n * 2^n)
    static void printSubsets(int[] arr ,int index , List<Integer> current){
        // base case
        if(index == arr.length){
            System.out.println(current);
            return;
        }
        // include current element
        List<Integer> newCurrent = new java.util.ArrayList<>(current);
        newCurrent.add(arr[index]);
        printSubsets(arr, index + 1, newCurrent);
        // exclude current element
        printSubsets(arr, index + 1, current);
    }

    // dp using memoization
    static void printSubsetsMemo(int[] arr, int index, List<Integer> current, List<List<Integer>> memo) {
        // base case
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        // check if the result is already computed
        if (memo.contains(current)) {
            return;
        }

        // include current element
        List<Integer> newCurrent = new java.util.ArrayList<>(current);
        newCurrent.add(arr[index]);
        printSubsetsMemo(arr, index + 1, newCurrent, memo);

        // exclude current element
        printSubsetsMemo(arr, index + 1, current, memo);

        // store the result in memo
        memo.add(new ArrayList<>(current));
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printSubsets(arr, 0, new java.util.ArrayList<>());
        // For memoization
        List<List<Integer>> memo = new java.util.ArrayList<>(); // to store computed subsets like [[1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]
        printSubsetsMemo(arr, 0, new java.util.ArrayList<>(), memo);
    }
}
