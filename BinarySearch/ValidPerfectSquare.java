
class Solution {
    public boolean isPerfectSquare(int num){
        if (num < 2) return true;

        int low = 2, high = num / 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long guessedSquare = (long) mid * mid; // to prevent overflow

            if (guessedSquare == num) {
                return true;
            } 
            else if (guessedSquare < num) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }
        return false;
        
    }
}

public class ValidPerfectSquare {
    public static void main(String[] args) {
        
    }
}
