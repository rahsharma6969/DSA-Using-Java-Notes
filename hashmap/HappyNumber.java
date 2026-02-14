/*202. Happy Number
Easy
Topics
premium lock icon
Companies
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.
 */
import java.util.HashMap;

class Solution {
    // time complexity: O(log n)    
    // space complexity: O(log n)
    public boolean  isHappy(int n){
       HashMap<Integer, Integer> map = new HashMap<>();

       while(n != 1){
        int sum = 0;
        while(n > 0){
        int digit = n % 10;
        sum += digit * digit;
        n /= 10;
       }
       if(map.containsKey(sum)){
        return false;
       }
       map.put(sum, 1);
       n = sum;
    }


        return true;
    }
}






public class HappyNumber {
    public static void main(String[] args) {
        
    } 
}