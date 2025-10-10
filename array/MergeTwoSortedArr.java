public class MergeTwoSortedArr {
    static int[] merge(int[] arr1, int[] arr2) {
        int n = arr1.length - arr2.length; // number of actual elements in arr1
        int m = arr2.length;

        int i = n - 1;          // last index of valid element in arr1
        int j = m - 1;          // last index of arr2
        int k = n + m - 1;      // last index of merged array (arr1’s total length)

        // Merge from the end
        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j--];
            }
        }

        // Copy remaining elements from arr2
        while (j >= 0) {
            arr1[k--] = arr2[j--];
        }

        return arr1;
    }
    public static void main(String[] args) {
         int[] arr1 = {1,2,3,0,0,0};    
            int[] arr2 = {2,5,6};
            int[] result = merge(arr1, arr2);
            for(int num : result){
                System.out.print(num + " ");
            }
    }
}
