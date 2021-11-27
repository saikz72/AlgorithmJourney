/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * Input: [0,1,0,3,12] Output: [1,3,12,0,0] Note:
 * 
 * You must do this in-place without making a copy of the array. Minimize the
 * total number of operations.
 */
public class MoveZeros {
    class Solution {
        public void moveZeroes(int[] nums) {
            if (nums.length == 1)
                return;

            for (int i = 1, lastZeroIndex = 0; i < nums.length; i++) {
                if (nums[lastZeroIndex] == 0 && nums[i] != 0) {
                    swap(nums, i, lastZeroIndex);
                    lastZeroIndex++;
                } else if (nums[lastZeroIndex] != 0) {
                    lastZeroIndex++;
                }
            }
        }

        // simple swap function
        public void swap(int[] nums, int i, int j) {
            nums[j] = nums[i];
            nums[i] = 0;
        }
    }
}