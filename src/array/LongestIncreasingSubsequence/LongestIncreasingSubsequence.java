package array.LongestIncreasingSubsequence;

/**
 * Created by tianle on 10/1/17.
 * <p>
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 */
public class LongestIncreasingSubsequence {

    /*
    * A nature idea is to see if it can be solved by divide and conquer. Basically, if the input array is divided from the middle,
    * we get two sub arrays. If we know the longest in left half and right half, can we somehow merge the results?
    * But it is difficult to merge as the input is unsorted.
    *
    * Switch to DP. If we know the best till i, can we infer the best to i+1 easily? It is difficult.
    *
    * The reason is that we loose the sorting information till now.
    *
    * Thus we switch to a different way to look at. We use T(i)
    * to denote the LIS ending at D(i). Now we can infer T(i+1). Since now D(i+1) is a must have, we need to
    * check all previous Ts whose ending is smaller than D(i+1) and increase by 1.
    *
    * */

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;

        int[] sofar = new int[length];

        int max = 0;

        for (int i = 0; i < length; i++) {
            int existingMax = 0;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    existingMax = Math.max(existingMax, sofar[j]);
                }
            }

            sofar[i] = existingMax + 1;

            max = Math.max(max, sofar[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence ls = new LongestIncreasingSubsequence();

        int[] input = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(ls.lengthOfLIS(input));
    }
}
