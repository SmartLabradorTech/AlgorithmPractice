package array.RangeSumQueryImmutable;

/**
 * Created by tianle on 10/17/17.
 * <p>
 * https://leetcode.com/problems/range-sum-query-immutable/description/
 */
public class RangeSumQueryImmutableImprove {

    private int[] sumTillNow;

    public RangeSumQueryImmutableImprove(int[] nums) {

        int length = nums.length;

        sumTillNow = new int[length];

        int sum = 0;

        for (int i = 0; i < length; i++) {
            sum += nums[i];

            sumTillNow[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sumTillNow[j];
        }

        return sumTillNow[j] - sumTillNow[i - 1];
    }

}
