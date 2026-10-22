/*
Best time to buy and sell stock
Subscribe to TUF+

Hints
Company
Given an array arr of n integers, 
where arr[i] represents price of the stock on the ith day.
Determine the maximum profit achievable by buying and selling 
the stock at most once. 

The stock should be purchased before selling it,
and both actions cannot occur on the same day.


Example 1

Input: arr = [10, 7, 5, 8, 11, 9]

Output: 6

Explanation: Buy on day 3 (price = 5) and sell on day 5 (price = 11), profit = 11 - 5 = 6.

Example 2

Input: arr = [5, 4, 3, 2, 1]

Output: 0

Explanation: In this case, no transactions are made. Therefore, the maximum profit remains 0. */

class Solution {
    
 
    public int stockBuySell(int[] arr, int n) {
       int minPrice = arr[0];
       int maxProfit = 0;
    

       for(int i =0; i< n; i++) {
         int cost = arr[i] - minPrice;
         maxProfit = Math.max(maxProfit, cost);
         minPrice = Math.min(minPrice, arr[i]);
       }
       return maxProfit;
    }
}


public class BuyAndSell {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {10, 7, 5, 8, 11, 9};
        int n = arr.length;
        System.out.println(s.stockBuySell(arr, n)); // Output: 6
    }
}