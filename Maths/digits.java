
public class digits {

    static int printDigits(int n) {

        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit;
            // System.out.println(digit);

            n = n / 10;
        }

        return sum;
    }

    static boolean isArmstrongNumber(int n) {
        int original = n;
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;

            sum += (digit * digit * digit);
            n = n / 10;
        }
        return sum == original;

    }

    static boolean isPalindrome(int n) {
        int og = n;
        int reversed = 0;
        while (n != 0) {
            int digits = n % 10;
            reversed = reversed * 10 + digits;
            n = n / 10;
        }
        return og == reversed;
    }

    public static void main(String[] args) {
        System.out.println(printDigits(3548));
        // if(isArmstrongNumber(133)){
        // System.out.println("Prime Number");
        // } else {
        // System.out.println("not an Prime Number");
        // }
        // }
        // if (isPalindrome(21)) {
        //     System.out.println("Palindrom Numer");
        // } else {
        //     System.out.println("not an palindrom");
        // }
    }

}
