// sort element based on frequency


import java.util.*;

public class FreqBasedSort {
    public static void main(String[] args) {

        int[] arr = {4,5,6,5,4,3};

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        Arrays.sort(arr, (a,b) -> map.get(b) - map.get(a));

        System.out.println(Arrays.toString(arr));
    }
}