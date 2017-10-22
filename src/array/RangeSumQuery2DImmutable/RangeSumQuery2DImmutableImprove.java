package array.RangeSumQuery2DImmutable;

/**
 * Created by tianle on 10/21/17.
 */
public class RangeSumQuery2DImmutableImprove {

    private int[][] aggregate;

    public RangeSumQuery2DImmutableImprove(int[][] matrix) {

        int rowCount = matrix.length;

        if (rowCount == 0) {
            return;
        }

        int colCount = matrix[0].length;

        if (colCount == 0) {
            return;
        }

        aggregate = new int[rowCount][colCount];

        aggregate[0][0] = matrix[0][0];

        for (int i = 1; i < rowCount; i++) {
            aggregate[i][0] = aggregate[i - 1][0] + matrix[i][0];
        }

        for (int j = 1; j < colCount; j++) {
            aggregate[0][j] = aggregate[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < colCount; j++) {
                aggregate[i][j] = matrix[i][j] +
                        aggregate[i][j - 1] + aggregate[i - 1][j] - aggregate[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int left = 0;

        if (col1 > 0) {
            left = aggregate[row2][col1 - 1];
        }

        int right = 0;

        if (row1 > 0) {
            right = aggregate[row1 - 1][col2];
        }

        int shared = 0;

        if (col1 > 0 && row1 > 0) {
            shared = aggregate[row1 - 1][col1 - 1];
        }

        return aggregate[row2][col2] - left - right + shared;
    }

    public static void main(String[] args) {

    }
}
