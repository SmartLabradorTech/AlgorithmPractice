package array.LongestIncreasingSubsequence;

import java.util.Arrays;

/**
 * Created by tianle on 10/9/17.
 */
public class LongestIncreasingSubsequenceBuiltInClean {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;

        int[] minEndingElements = new int[length];
        int maxLength = 0;

        for (int i = 0; i < length; i++) {
            //current element is numbs[i]
            // try to see the position of this element
            int index = Arrays.binarySearch(minEndingElements, 0, i, nums[i]);

            if (index < 0) {
                // it doesn't exist in current
                index = -(index + 1);

                if (index == maxLength + 1) {
                    minEndingElements[index] = nums[i];
                    maxLength++;
                } else {
                    minEndingElements[index] = Math.min(nums[i], minEndingElements[index]);
                }

            }

        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequenceBuiltInSorting ls = new LongestIncreasingSubsequenceBuiltInSorting();

        int[] input2 = {10, 9, 2, 5, 3, 7, 101, 18};

        int[] input1 = {2, 3};

        int[] input3 = {4, 10, 4, 3, 8, 9};

        System.out.println(ls.lengthOfLIS(input2));

//        System.out.println(Arrays.binarySearch(input1, 4));
    }
}
