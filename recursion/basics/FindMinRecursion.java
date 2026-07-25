public class FindMinRecursion {

    static int findMin(int[] arr, int index){
        // base case 

        if(index == arr.length - 1){
            return arr[index];
        }

        // recursive call
        int minInRest = findMin(arr, index + 1);

        return Math.min(arr[index], minInRest);
    }

    public static void main(String[] args) {
        
        int[] arr = {11, 5, 1, 9, 2};
        int min = findMin(arr, 0);
        System.out.println("Minimum element in the array: " + min);
    }
}
