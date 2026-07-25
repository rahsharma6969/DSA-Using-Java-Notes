/* Print all subsequences of a given array
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
 * 
 * input : arr = [1, 2, 3]
 * output : [], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]
*/

import java.util.*;

class SubsequenceForArray {
    public void printSubsequences(int[] arr, int index, List<Integer> current) {
        // base case
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        // include the current element
        current.add(arr[index]);
        printSubsequences(arr, index + 1, current);

        // exclude the current element
        current.remove(current.size() - 1);
        printSubsequences(arr, index + 1, current);
    }
}

public class Subsequence {

    static void printsubsequences(String str , int index, String current){
        // base case 
        if(str.length() == index){
            System.out.println(current);
            return;
        }

 
        // include the current character
        printsubsequences(str, index + 1, current + str.charAt(index));
        // exclude the current character
        printsubsequences(str, index + 1, current);
    }
    public static void main(String[] args) {
        String str = "abc";
        printsubsequences(str, 0, "");

        SubsequenceForArray subsequenceForArray = new SubsequenceForArray();
        int[] arr = {1, 2, 3};
        subsequenceForArray.printSubsequences(arr, 0, new ArrayList<>());
    }
}
