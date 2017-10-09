package array.LongestIncreasingSubsequence;

import java.util.Arrays;

/**
 * Created by tianle on 10/2/17.
 * In DP version of the algo, our goal is find the existing longest LIS to append.
 * <p>
 * however, the linear scan takes O(N) which makes total O(N^2) complexity.
 * <p>
 * So, the question is how we can efficiently find the longest LIS which whose last element
 * is small than the current value under check.
 * <p>
 * If we can track the min last element of LIS of length i in array p[].
 * p[1] means the min last element among all LIS of length 1
 * p[2] means the min last element among all LIS of length 2
 * Now let's assume we have finished collecting information for i, and we are evaluating i+i
 * <p>
 * what will happen?
 * <p>
 * Note that previously we were trying to find the longest LIS whose last element is smaller than
 * nums[i].
 * <p>
 * if till i, we can have LIS of max length k,
 * <p>
 * then p[1],...p[k]
 * <p>
 * what can we say about p[m], p[m+1]
 * <p>
 * p[m] indicates the smallest largest element among all LIS of length m
 * p[m+1] indicates the smallest largest element among all LIS of length m+1
 * so we must have p[m+1] > p[m]
 * <p>
 * otherwise if p[m+1] <= p[m], then p[m] is invalid because the LIS of p[m+1] must have a smaller p[m].
 * we must have p[m+1] > p[m]
 */
public class LongestIncreasingSubsequenceClean {

    // what is the problem
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;

        int[] minEndingElementOfLength = new int[length + 1];

        minEndingElementOfLength[1] = nums[0];
        int max = 1;
        for (int i = 1; i < length; i++) {
            // what do I want to do here? I am at index i, current element is nums[i]
            // I want to find if there is the max j whose minEndingElementOfLength[j] < nums[i]
            int maxLengthToAppend = find(minEndingElementOfLength, 1, max, nums[i]);
            int position = maxLengthToAppend + 1;

            if (position > max) {
                max = position;
                minEndingElementOfLength[max] = nums[i];
            } else {
                minEndingElementOfLength[position] = Math.min(minEndingElementOfLength[position], nums[i]);
            }
        }

        return max;
    }

    private int find(int[] a, int start, int end, int target) {
        if (start > end) {
            return start - 1;
        }

        if (start == end) {
            if (target <= a[start]) {
                return start - 1;
            }

            return start;
        }

        int mid = (start + end) / 2;

        if (a[mid] == target) {
            return mid - 1;
        }

        if (a[mid] < target) {
            return find(a, mid + 1, end, target);
        }

        return find(a, start, mid - 1, target);
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequenceClean ls = new LongestIncreasingSubsequenceClean();

        int[] input2 = {10, 9, 2, 5, 3, 7, 101, 18};

        int[] input1 = {2, 3};

        int[] input3 = {4, 10, 4, 3, 8, 9};

        System.out.println(ls.lengthOfLIS(input3));

        System.out.println(Arrays.binarySearch(input1, 4));
    }

}
