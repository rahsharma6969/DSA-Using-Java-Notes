/*Sort First Half Ascending & Second Half Descending
input: 1 2 3 4 5 6 7 8
output: 1 2 3 4 8 7 6 5
*/

import java.util.Arrays;
import java.util.HashMap;


public class Practice {

static void sortHalfAsscendingHalfDescending1(int[] arr) {
    int n = arr.length;
    int mid =n / 2;

    Arrays.sort(arr);

    // first half
    int i = mid ;
    int j = n-1;
 
        while( i < j ){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

// time complexity of this approach is O(nlogn) and space complexity is O(1)
static void sortHalfAsscendingHalfDescending(int[] arr){
    int n = arr.length;
    int mid = n/2;
    // sort the entire array in ascending order
    Arrays.sort(arr);
    // reverse the second half of the array
    for(int i = mid, j = n-1; i<j; i++, j--){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

// Sort Based on Frequency (Very Common)
// input : 2 3 2 4 5 12 2 3 3 3 12
// output :3 3 3 3 2 2 2 12 12 4 5

static void sortBasedOnFrequency(int[] arr) {
    int n = arr.length;

    HashMap<Integer, Integer> freqMap = new HashMap<>();

    // Count frequency
    for (int num : arr) {
        freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }

    // Convert int[] to Integer[]
    Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);

    // Sort using custom comparator
    Arrays.sort(nums, (a, b) -> {
        int freqA = freqMap.get(a);
        int freqB = freqMap.get(b);

        if (freqA == freqB) {
            return a - b;          // smaller number first
        }
        return freqB - freqA;     // higher frequency first
    });

    // Copy back to original array
    for (int i = 0; i < n; i++) {
        arr[i] = nums[i];
    }
}
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
         sortHalfAsscendingHalfDescending1(arr);
            for(int i=0; i<arr.length; i++){
                System.out.print(arr[i] + " ");
    }

            // System.out.println();
            // int[] arr2 = {2,3,2,4,5,12,2,3,3,3,12};
            // sortBasedOnFrequency(arr2);
            // for(int i=0; i<arr2.length; i++){
            //     System.out.print(arr2[i] + " ");
            // }
  }
}
