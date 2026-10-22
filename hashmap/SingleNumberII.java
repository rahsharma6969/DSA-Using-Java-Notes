class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int bit = 0; bit < Integer.SIZE; bit++) {
            int bitCount = 0;
            for (int num : nums) {
                bitCount += (num >> bit) & 1;
            }
            if (bitCount % 3 != 0) {
                result |= 1 << bit;
            }
        }

        return result;
    }

    // using sorting approach
    public int singleNumberSorting(int[] nums) {
        Arrays.sort(nums);

    for (int i = 0; i < nums.length; i += 3) {
        if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
            return nums[i];
        }
    }

    return 0;// This line should never be reached if input is valid
    }
}

public class SingleNumberII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int positiveResult = sol.singleNumber(new int[] {2, 2, 3, 2});
        int negativeResult = sol.singleNumber(new int[] {-2, -2, -2, -7});

        if (positiveResult != 3 || negativeResult != -7) {
            throw new AssertionError("Single Number II test failed");
        }

        System.out.println(positiveResult);
        System.out.println(negativeResult);
    }
}
