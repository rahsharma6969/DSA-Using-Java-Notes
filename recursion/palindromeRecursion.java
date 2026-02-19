public class palindromeRecursion {

    static boolean isPalindrome(String str, int start, int end) {

        if(str.charAt(start) != str.charAt(end)){
            return false;
}
        if (start >= end) {
            return true;
        }
      return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String str = "madan";
        if (isPalindrome(str, 0, str.length() - 1)) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }
    }
}
