package array;

public class MaximumSubarray {

    // https://leetcode.com/problems/maximum-subarray/
    public int maxSubArray(int[] nums) {
        int sumEndingAtCurrent = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (sumEndingAtCurrent > 0) {
                sumEndingAtCurrent += nums[i];
            } else {
                sumEndingAtCurrent = nums[i];
            }

            max = Math.max(sumEndingAtCurrent, max);

        }

        return max;
    }

}
