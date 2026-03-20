

public class Sort {
// time complexity of bubble sort is O(n^2) and space complexity is O(1)
   public static void bubbleSort(int[] arr){
    int n = arr.length;

    for(int i=0;i<n; i++){
        for(int j=0; j<n-i-1; j++) {
            if(arr[j] > arr[j+1]){
                int temp =arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
    }
   }
   static int findSmallest(int arr[], int smallest){
    int n = arr.length;
    for(int j = smallest+1; j<n; j++){
            if(arr[j] < arr[smallest]){
                smallest = j;
            }
        }
        return smallest;
   }
   // time complexity of selection sort is O(n^2) and space complexity is O(1)
   static void selectionSort(int[] arr) {
    int n = arr.length;
    
    for(int i=0; i<n-1; i++){
        int smallest = findSmallest(arr,i);
        int temp = arr[smallest];
        arr[smallest] = arr[i];
        arr[i] = temp;    
    }
   }

   static void insertionSort(int[] arr){
    // [4 1 5 2 3]
     int n = arr.length;
     for(int i=1; i<n; i++){
        int curr = arr[i];
        int prev = i-1;
        while(prev>=0 && arr[prev] > curr){
            arr[prev+1] = arr[prev];
            prev--;
        }
        arr[prev+1] = curr;
     }
   }

    public static void main(String[] args) {
        // int [] arr = new int[];
        int[] arr   = {7,8,2,3,1};
        bubbleSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        
    }
}
