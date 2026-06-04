/*
Clustered Ice Cream Selection

You are given:

N ice cream bars
each bar has cost c[i]
total budget C
maximum allowed price difference D

You must find the maximum number of ice cream bars such that:

Total selected cost ≤ C
Difference between any two selected bars ≤ D

5
20
4
2
5
6
8
10

Output : 3
*/
import java.util.Arrays;

class Solution {
    public int maxCreams(int N, int C, int D, int[] c) {
        Arrays.sort(c);
        int sum= 0 , count =0, l=0;

        for(int r = 0; r<N ; r++) {
          sum += c[r];

          while(sum > C || c[r] - c[l] > D) {
            sum -= c[l];
            l++;
        
        }
        count = Math.max(count, r-l+1);
    }
        return count;
    }
}
public class SlidingWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        int[] c = new int[N];
        for(int i = 0; i < N; i++) {
            c[i] = sc.nextInt();
        }

        Solution sol = new Solution();
        System.out.println(sol.maxCreams(N, C, D, c));
    }
}
