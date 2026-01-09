
import java.util.*;
public class Sort {
    
    static void selectionSort(int[ ] arr){
          
        for(int i=0; i < arr.length - 1; i++){
            int smallest = i;
            for(int j = i+1; j< arr.length; j++){
                if(arr[smallest] >arr[j] ){
                    smallest = j;
                }
    
                }
                if(smallest != i){
                 int temp = arr[i];
                 arr[i]  = arr[smallest];
                 arr[smallest] = temp;
                }
                
            }
        }
    


    static void bubbleSort(int[] arr){  // Time Complexity O(n^2)
        int n = arr.length;

        for(int i=0; i<n-1;i++){
            for(int j=0; j<n-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        // int [] arr = new int[];
        int[] arr   = {7,8,2,3,1};
        bubbleSort(arr);
        System.out.println("Bubble Sort"+Arrays.toString(arr));
        // selectionSort(arr);
        // System.out.println("Selection Sort"+Arrays.toString(arr));
        
    }

}
