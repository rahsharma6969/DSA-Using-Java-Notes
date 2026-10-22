/*Find whether a number is palindrome or not */


public class PalindromeNumber {

    static boolean isPalinndrome(int n) {
        int og = n;
        int reversed = 0;
        while(n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n = n / 10;
                }
                return og == reversed;
    }
    public static void main(String[] args) {
        int n = 12312;

        System.out.println(isPalinndrome(n));
    }
}