/**
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has the
 * largest sum = 6. Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 **/

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
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

    public static void main(String arg[]) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(arr));
    }
}