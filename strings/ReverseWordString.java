/*
151. Reverse Words in a String
Solved
Medium
Topics
premium lock icon
Companies
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"
 */


public class ReverseWordString {

    // time complexity: O(n)
    // space complexity: O(n)
   public static String reverseWords(String s) {
    String[] words = s.trim().split("\\s+");// remove leading and trailing spaces and split by one or more spaces
    StringBuilder sb = new StringBuilder();
    for (int i = words.length - 1; i >= 0; i--) { // since we have converted string to array of words we can easily
    //  reverse the order of words by traversing from end to start
        sb.append(words[i]);
        if (i != 0) sb.append(' ');
    }
    return sb.toString(); // Convert StringBuilder to String and return so  that caller gets String type
}

    public static void countVowelsAndConsonants(String s) {
        int vowels = 0;
        int consonants = 0;

        s = s.toLowerCase();// 

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static String removeSpaces(String s) {
        return s.replace(" ", "");
    }

    public static void main(String[] args) {
        String s = "  hello world  ";
        String reversed = reverseWords(s);
        System.out.println("Reversed Words: '" + reversed + "'");
    //     countVowelsAndConsonants(s);
    //     System.out.println("Without Spaces: '" + removeSpaces(s) + "'");
     }
}
