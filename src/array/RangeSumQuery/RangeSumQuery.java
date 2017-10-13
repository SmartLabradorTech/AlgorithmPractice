package array.RangeSumQuery;

/**
 * Created by tianle on 10/10/17.
 * https://leetcode.com/problems/range-sum-query-mutable/description/
 */
public class RangeSumQuery {

    private int[] nums;
    private int[][] sums;

    public RangeSumQuery(int[] nums) {
        this.nums = nums;

        int length = nums.length;

        sums = new int[length][length];

        for (int i = 0; i < length; i++) {

            int sum = 0;

            for (int j = i; j < length; j++) {

                sum += nums[j];
                sums[i][j] = sum;
            }
        }
    }

    // This can take up to O(N^2) time complexity. Can we improve this?
    public void update(int i, int val) {
//        for (int p = 0; p <= i; p++) {
//            for (int q = i; q < nums.length; q++) {
//                sums[p][q] -= nums[i];
//                sums[p][q] += val;
//            }
//        }
//
//        nums[i] = val;

        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        int sum = 0;

        for (int p = i; p <= j; p++) {
            sum += nums[p];
        }

        return sum;
    }
}
