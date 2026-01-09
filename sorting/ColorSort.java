/*
 * Given an array with n objects colored red, white or blue,
 * sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * You must solve this problem without using the library's sort function.
 Input: nums = [2,0,2,1,1,0]
 Output: [0,0,1,1,2,2]

*/

public class ColorSort {

    static void sortColors(int[] nums) {
        int low, mid, high;
        low = mid = 0;
        high = nums.length - 1;

        while (low <= high && mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }
}
