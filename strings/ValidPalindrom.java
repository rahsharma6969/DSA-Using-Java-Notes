/*

Code
Testcase
Testcase
Test Result
125. Valid Palindrome
Solved
Easy
Topics
premium lock icon
Companies
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
*/

class Solution {

    // brute force approach
    // time complexity: O(n)
    // space complexity: O(n)
    public boolean isPalindromeBruteForce(String s){
        // convert to lowercase
        s = s.toLowerCase();
        StringBuilder filtered = new StringBuilder();

        // concatenate only alphanumeric characters i.e letters and digits
        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                filtered.append(c);
            }
        }

        String filteredStr = filtered.toString();
        String reveString = filtered.reverse().toString();
        if(!filteredStr.equals(reveString)){
            return false;
        }

        return true;

    }

    // time complexity: O(n)
    // space complexity: O(1)
    // public boolean isPalindrome(String s) {
    //     int left = 0;
    //     int right = s.length() - 1;

    //     while (left < right) {
    //         // Move left pointer to next alphanumeric character
    //         while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
    //             left++;
    //         }
    //         // Move right pointer to previous alphanumeric character
    //         while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
    //             right--;
    //         }

    //         // Compare characters (case-insensitive)
    //         if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
    //             return false;
    //         }

    //         left++;
    //         right--;
    //     }

    //     return true;
    // }


    }



public class ValidPalindrom {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "A man, a plan, a canal: Panama";
        boolean result = sol.isPalindromeBruteForce(s);
        System.out.println("Is the string a valid palindrome? " + result);
        
    }
}
