package array.RangeSumQueryMutable;

//https://leetcode.com/problems/range-sum-query-mutable/

class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public void update(int i, int val) {
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        int sum = 0;

        for (int s = i; s <= j; s++) {

            sum += nums[s];
        }

        return sum;
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
