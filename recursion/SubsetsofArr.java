
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
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printSubsets(arr, 0, new java.util.ArrayList<>());
    }
}
