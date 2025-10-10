class Solutions {
    int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }

            }
        }
        return count;
    }
}

public class SubArraySumEqualsTOk {
    public static void main(String[] args) {
        Solutions sol = new Solutions();
        int[] nums = {1, 2, 3};
        int k = 3;
        int result = sol.subarraySum(nums, k);
        System.out.println("Number of subarrays: " + result);

       
    }
}
