import java.util.Stack;
import java.util.ArrayList;
/*
  Previous Smaller Element
Last Updated : 12 Sep, 2025
Given an array arr[], find the Previous Smaller Element (PSE) for every element in the array.

The Previous Smaller Element of an element x is defined as the first element to its left in the array that is smaller than x.
If no such element exists for a particular position, the PSE should be considered as -1.
 Examples: 

Input: arr[] = [1, 6, 2]
Output: [-1, 1, 1]
Explanation: For the first element 1, there is no element to its left, so the result is -1. For 6, the previous smaller element is 1. For 2, the previous smaller element is also 1, since it is the closest smaller number when looking left.

Input: arr[] = [1, 5, 0, 3, 4, 5]
Output: [-1, 1, -1, 0, 3, 4]

*/
public class PreviousSmallerElememt {

    static ArrayList<Integer> previousSmallerElement(int[] arr){
       int n = arr.length;

         ArrayList<Integer> result = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    result.add(-1);
                } else {
                    result.add(stack.peek());
                }

                stack.push(arr[i]);
            }
            return result;
    
    
    }
    public static void main(String[] args) {
        
    }
}
