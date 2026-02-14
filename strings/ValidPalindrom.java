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

    
    public boolean isPalindromeBruteForce(String s){
      
        // convert the string to lowercase and remove non-alphanumeric characters
        StringBuilder filtered = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                filtered.append(Character.toLowerCase(c));
            }
        }

        String filteredStr = filtered.toString();
        String reversedStr = filtered.reverse().toString();
        return filteredStr.equals(reversedStr);

    }

    
// using two pointers approach
  public boolean isPalindromeTwoPointers(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right){
            // move left pointer to the right until it points to an alphanumeric character
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            // move right pointer to the left until it points to an alphanumeric character
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            // compare characters at left and right pointers
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
       
           
        return true;


    }
}



public class ValidPalindrom {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "A man, a plan, a canal: Panama";
        boolean result = sol.isPalindromeBruteForce(s);
        System.out.println("Is the string a valid palindrome? " + result);
        
    }
}
