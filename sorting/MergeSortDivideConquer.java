import java.util.Arrays;

public class MergeSortDivideConquer {

    public static void main(String[] args) {
        int[] arr = {7, 8, 2, 3, 1, 9, 4};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        mergeSort(arr, 0, arr.length - 1);
        
        System.out.println("Sorted array:   " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high) {
        // Base case: subarray of size 0 or 1 is already sorted (Conquer trivial case)
        if (low < high) {
        
            int mid = low + (high - low) / 2;  

           
            mergeSort(arr, low, mid);
      
            mergeSort(arr, mid + 1, high);

          
            merge(arr, low, mid, high);
        }
    }

   
    private static void merge(int[] arr, int low, int mid, int high) {
        // Create temporary arrays for the two halves
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[low + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];

        // Merge the temporary arrays back into arr[low ... high]
        int i = 0, j = 0; 
        int k = low;       

        // Compare and merge in sorted order
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArr[], if any
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArr[], if any
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}