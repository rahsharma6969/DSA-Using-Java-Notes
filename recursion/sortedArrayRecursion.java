public class sortedArrayRecursion {
    
    static boolean isSorted(int[] arr, int index){
       

       // Base case
    if (index == arr.length - 1) {
        return true;
    }

    // If current pair is not sorted
    if (arr[index] > arr[index + 1]) {
        return false;
    }

    // Check remaining array
    return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 3;
        boolean isSorted = isSorted(arr, 0);
      

        System.out.println("Is the array sorted? " + isSorted);
  
    }
}
