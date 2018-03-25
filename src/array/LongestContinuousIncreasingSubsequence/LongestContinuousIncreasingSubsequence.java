package array.LongestContinuousIncreasingSubsequence;

/**
 * Created by tianle on 3/25/18.
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
 */
public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {

        int length = nums.length;

        if (length == 0) {
            return 0;
        }

        int current = 1;
        int max = 1;

        for (int i = 1; i < length; i++) {

            if (nums[i] > nums[i - 1]) {
                current++;
                max = Math.max(current, max);
            } else {
                current = 1;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence s = new LongestContinuousIncreasingSubsequence();

//        int[] input = {1, 3, 5, 4, 7};
        int[] input = {2, 2, 2, 2, 2};

        System.out.println(s.findLengthOfLCIS(input));
    }
}
