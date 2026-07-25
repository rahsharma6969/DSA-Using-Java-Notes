public class FindmaxRecursion {

    public static int findMax(int[] arr, int index) {

    // Base case
    if (index == arr.length - 1) {
        return arr[index];
    }

    // Recursive call
    int smallMax = findMax(arr, index + 1);

    // Compare current element with smaller problem result
    return Math.max(arr[index], smallMax);
}

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 9, 2};
        int max = findMax(arr, 0);
        System.out.println("Maximum element in the array: " + max);
    }
}
