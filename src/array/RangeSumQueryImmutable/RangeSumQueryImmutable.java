package array.RangeSumQueryImmutable;

/**
 * Created by tianle on 10/17/17.
 * https://leetcode.com/problems/range-sum-query-immutable/description/
 * <p>
 * This approach takes O(N^2) space complexity and time complexity. O(1) to query.
 * <p>
 * But it cannot AC. We need to bring down.
 */
public class RangeSumQueryImmutable {

    private int[][] precal;

    public RangeSumQueryImmutable(int[] nums) {
        int length = nums.length;

        precal = new int[length][length];

        for (int i = 0; i < length; i++) {
            int sum = 0;

            for (int j = i; j < length; j++) {
                sum += nums[j];
                precal[i][j] = sum;
            }
        }
    }

    public int sumRange(int i, int j) {
        return precal[i][j];
    }
}
