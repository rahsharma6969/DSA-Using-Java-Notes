package slidingwindow;
/*
1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
Medium
Topics
premium lock icon
Companies
Hint
Given an array of integers arr and two integers k and threshold, return the number of sub-arrays of size k and average greater than or equal to threshold.

 

Example 1:

Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
Output: 3
Explanation: Sub-arrays [2,5,5],[5,5,5] and 
[5,5,8] have averages 4, 5 and 6 respectively. 
All other sub-arrays of size 3 have averages less than 4 (the threshold). */

class Solution{
   // time complexity: O(n)
    // space complexity: O(1)

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int numOfSubarrays = 0;
        int n= arr.length;
        int windowSum = 0;
        // calculate sum of first k elements
        for (int i = 0; i < k; i++) {  // time complexity: O(k)
            windowSum += arr[i];
        }

        for(int i=k; i<=n;i++){    // time complexity: O(n-k+1)
            if(windowSum >= threshold* k){
                numOfSubarrays++;
            }
            if(i < n){
                windowSum += arr[i];        // add new element
                windowSum -= arr[i - k];    // remove old element
            }
        }

        return numOfSubarrays;
    }

    // 
}


public class NoOfSubArr {
    
}
