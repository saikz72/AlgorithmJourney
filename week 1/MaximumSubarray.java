
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // use Kadane's Algorithm
        if (nums.length == 1 || nums == null)
            return nums[0];

        int localSum = nums[0];
        int globalSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            localSum = Math.max(nums[i], localSum + nums[i]);
            globalSum = Math.max(localSum, globalSum);
        }
        return globalSum;
    }
}