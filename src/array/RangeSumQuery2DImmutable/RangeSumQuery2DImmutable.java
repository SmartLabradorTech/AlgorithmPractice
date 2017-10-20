package array.RangeSumQuery2DImmutable;

/**
 * Created by tianle on 10/17/17.
 * <p>
 * https://leetcode.com/problems/range-sum-query-2d-immutable/description/
 */
public class RangeSumQuery2DImmutable {

    private int[][] matrix;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }

}
