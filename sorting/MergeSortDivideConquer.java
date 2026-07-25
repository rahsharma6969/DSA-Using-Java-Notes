import java.util.Arrays;

public class MergeSortDivideConquer {

    public static void main(String[] args) {
        int[] arr = {7, 8, 2, 3, 1, 9, 4};
        System.out.println("Original array: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:   " + Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int temp[] = new int[right - left + 1];
        int i = left , j = mid + 1 , k=0;

        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            }else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while(j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for(int l=0 ; l<temp.length ; l++) {
            arr[left + l] = temp[l];
        }
    }
}
