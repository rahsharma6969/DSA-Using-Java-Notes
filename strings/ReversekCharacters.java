/*
Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.

 

Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:

Input: s = "abcd", k = 2
Output: "bacd" */

class Solution {
    public String reverseStr(String s, int k) {

        if( k <=0 || s == null || s.length() == 0) return s;
        if(k > s.length()) k = s.length();

        int i = k;
        char[] arr = s.toCharArray();

        while ( i< arr.length) {
            reverse(arr, i-k, i-1);
            i += 2*k;
        }
        return new String(arr);
    }
    
    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
public class ReversekCharacters {
    
}
