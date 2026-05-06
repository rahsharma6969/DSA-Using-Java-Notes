
public class Practice {
    public static void  findMinMax(int[] arr) {
        // int min = Integer.MAX_VALUE;
        // int max = Integer.MIN_VALUE;

        // Arrays.sort(arr);
        // min = arr[0];
        // max = arr[arr.length - 1];
        // System.out.println("Min: " + min);
        // System.out.println("Max: " + max);
        int min = arr[0];
        int max = arr[0];
        for(int i = 1; i< arr.length; i++){
            if(arr[i] < min) {
                min = arr[i];
            } 
            // we didn't use else if because we want to check for both conditions for each element in the array.
            // exampl arr[i] is both less than min and greater than max, we want to update both min and max.
            if(arr[i] > max) { 
                max = arr[i];
            }
        }
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);

    }

    static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
    // 
    static int MaxSubArrSum(int[] arr) {
        int n = arr.length;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE ;
        for(int i=0; i<n ; i++) {
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);
            if(currSum < 0) {
               currSum = 0 ;
            }
            
        }
        return maxSum;

    }

    //Find second largest element
    static int Secondlargest(int[] arr) {
       if (arr == null || arr.length < 2) {
           return -1;
       }

       int largest = Integer.MIN_VALUE;
       int secondLargest = Integer.MIN_VALUE;

       for (int num : arr) {
           if (num > largest) {
               secondLargest = largest;
               largest = num;
           } else if (num > secondLargest && num != largest) {
               secondLargest = num;
           }
       }

       return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5};

        findMinMax(arr);
        System.out.println("Missing Number: " + findMissingNumber(arr));
        System.out.println("Maximum Subarray Sum: " + MaxSubArrSum(arr));
        System.out.println("Second Largest Element: " + Secondlargest(arr));
    }
}
