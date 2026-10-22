/*
Roman to Integer
Subscribe to TUF+

Hints
Company
Roman numerals are represented by seven different symbols:

I = 1
V = 5
X = 10
L = 50
C = 100
D = 500
M = 1000


Roman numerals are typically written from largest to smallest, left to right. However, in specific cases, a smaller numeral placed before a larger one indicates subtraction.



The following subtractive combinations are valid:

I before V (5) and X (10) → 4 and 9
X before L (50) and C (100) → 40 and 90
C before D (500) and M (1000) → 400 and 900


Given a Roman numeral, convert it to an integer.


Example 1

Input: s = "III"

Output: 3

Explanation: III = 1 + 1 + 1 = 3

Example 2

Input: s = "XLII"

Output: 42

Explanation: XL = 40, II = 2 → 40 + 2 = 42
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        int total = 0;
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        for(int i = 1; i < s.length(); i++) {
            int curr = romanMap.get(s.charAt(i));
            int prev = romanMap.get(s.charAt(i - 1));
            if(curr > prev) {
                total -= prev;
            } else {
                total += prev;
            }
        }
            
        return total;
    }
}