/*
Pow(x,n)
Subscribe to TUF+

Hints
Company
Implement the power function pow(x, n) , which calculates the x raised to n i.e. xn.



Note : In output print 4 digits places after decimal point.


Example 1

Input : x = 2.0000 , n = 10

Output : 1024.0000

Explanation : Answer = 2^10 => 1024.

Example 2

Input : x = 2.0000 , n = -2

Output : 0.2500

Explanation : Answer = 2^(-2) = 1/4 => 0.25.
 */
import java.util.*;

class Solution {

     public double myPow2(double x, int n) {
          //your code goes here
          double ans = Math.pow(x , n);

          return ans;
    }


    public double myPow(double x, int n) {
        long exponent = n;
        if (exponent < 0) {
            x = 1 / x;
            exponent = -exponent;
        }

        double result = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result *= x;
            }
            x *= x;
            exponent >>= 1;
        }

        return result;
    }
}


public class PowerX&N {
    
}
