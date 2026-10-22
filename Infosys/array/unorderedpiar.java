package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
        public long countPairs(int[] a, int D, int M) {
        Map<String, Long> freq = new HashMap<>();
        long count = 0;

        for (int x : a) {
            int r1 = Math.floorMod(x, M);
            int r2 = Math.floorMod(x, D);
            int need = (D - r2) % D;

            count += freq.getOrDefault(r1 + "," + need, 0L);

            String key = r1 + "," + r2;
            freq.put(key, freq.getOrDefault(key, 0L) + 1);
        }

        return count;
    }

    public int countPairs(int n, int D, int M , int[] arr) {
        int count = 0;

        for(int i=0; i<n ; i++) {
            for(int j=i+1; j< n; j++ ) {
                long sum = arr[i] + arr[j];
                long difference = Math.abs(arr[i] - arr[j]);
                 if (sum % D == 0 && difference % M == 0) {
                    count++;
                }
            }
        }
            return  count;
    }


}
public class unorderedpiar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
    
}
