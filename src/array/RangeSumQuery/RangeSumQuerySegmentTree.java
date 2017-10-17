package array.RangeSumQuery;

/**
 * Created by tianle on 10/16/17.
 */
public class RangeSumQuerySegmentTree {

    private int[] sumTree;
    private int length;

    public RangeSumQuerySegmentTree(int[] nums) {
        int length = nums.length;
        this.length = length;

        if (length == 0) {
            return;
        }

        sumTree = new int[length * 4];

        build(nums, 0, length - 1, 0);
    }

    private int build(int[] nums, int start, int end, int current) {
        if (start == end) {
            sumTree[current] = nums[start];
            return nums[start];
        }

        int mid = (start + end) / 2;

        sumTree[current] = build(nums, start, mid, 2 * current + 1) +
                build(nums, mid + 1, end, 2 * current + 2)
        ;

        return sumTree[current];
    }

    public void update(int i, int val) {
        update(i, val, 0, length - 1, 0);
    }

    private int update(int i, int val, int start, int end, int current) {
        if (i < start || i > end) {
            return sumTree[current];
        }

        if (start == end) {
            sumTree[current] = val;
            return val;
        }

        int mid = (start + end) / 2;

        sumTree[current] = update(i, val, start, mid, 2 * current + 1) +
                update(i, val, mid + 1, end, 2 * current + 2);

        return sumTree[current];
    }

    public int sumRange(int i, int j) {

        return sum(i, j, 0, length - 1, 0);
    }

    private int sum(int i, int j, int start, int end, int current) {

        if (j < start) {
            return 0;
        }

        if (i > end) {
            return 0;
        }

        if (i <= start && j >= end) {
            return sumTree[current];
        }

        int mid = (start + end) / 2;

        return sum(i, j, start, mid, current * 2 + 1) + sum(i, j, mid + 1, end, current * 2 + 2);
    }

    public static void main(String[] args) {

        /*
        * ["NumArray","sumRange","update","sumRange","sumRange","update","update","sumRange","sumRange","update","update"]
[[[-28,-39,53,65,11,-56,-65,-39,-43,97]],[5,6],[9,27],[2,3],[6,7],[1,-82],[3,-72],[3,7],[1,8],[5,13],[4,-67]]
        * */

        int[] input = {-28, -39, 53, 65, 11, -56, -65, -39, -43, 97};

        RangeSumQuerySegmentTree r = new RangeSumQuerySegmentTree(input);
        r.update(9, 27);
        r.update(1, -82);
        r.update(3, -72);
        r.update(5, 13);
        r.update(4, -67);
    }
}
