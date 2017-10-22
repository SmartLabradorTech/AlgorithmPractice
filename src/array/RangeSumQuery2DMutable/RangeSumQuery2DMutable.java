package array.RangeSumQuery2DMutable;

import java.util.Arrays;

/**
 * Created by tianle on 10/22/17.
 * <p>
 * https://leetcode.com/problems/range-sum-query-2d-mutable/description/
 * Still time out!!!!!!!!!
 *
 * There is math needed to compute the memory allocation.
 *
 */
public class RangeSumQuery2DMutable {
    private int[] tree;
    private int rowC;
    private int colC;

    public RangeSumQuery2DMutable(int[][] matrix) {
        rowC = matrix.length;

        if (rowC == 0) {
            return;
        }

        colC = matrix[0].length;

        if (colC == 0) {
            return;
        }

        tree = new int[100 * rowC * colC];

        build(0, 0, rowC - 1, colC - 1, 0, matrix);

        System.out.println(Arrays.toString(tree));
    }

    private int build(int row1, int col1, int row2, int col2, int position, int[][] matrix) {
        if (row1 > row2 || col1 > col2) {
            return 0;
        }

        if (row1 == row2 && col1 == col2) {
            tree[position] = matrix[row1][col1];
            return tree[position];
        }

        int midRow = (row1 + row2) / 2;
        int midCol = (col1 + col2) / 2;

        int sum = build(row1, col1, midRow, midCol, 4 * position + 1, matrix)
                + build(row1, midCol + 1, midRow, col2, 4 * position + 2, matrix)
                + build(midRow + 1, col1, row2, midCol, 4 * position + 3, matrix)
                + build(midRow + 1, midCol + 1, row2, col2, 4 * position + 4, matrix);

        tree[position] = sum;

        return sum;
    }

    public void update(int row, int col, int val) {
        update(row, col, val, 0, 0, rowC - 1, colC - 1, 0);
    }

    private int update(int row, int col, int val, int row1, int col1, int row2, int col2, int position) {
        if (!isWithin(row, col, row1, col1, row2, col2)) {
            return tree[position];
        }

        if (row1 == row2 && col1 == col2) {
            tree[position] = val;
            return tree[position];
        }

        if (row1 > row2 || col1 > col2) {
            return 0;
        }

        int midRow = (row1 + row2) / 2;
        int midCol = (col1 + col2) / 2;

        tree[position] =
                update(row, col, val, row1, col1, midRow, midCol, 4 * position + 1) +
                        update(row, col, val, row1, midCol + 1, midRow, col2, 4 * position + 2) +
                        update(row, col, val, midRow + 1, col1, row2, midCol, 4 * position + 3) +
                        update(row, col, val, midRow + 1, midCol + 1, row2, col2, 4 * position + 4);

        return tree[position];
    }

    private boolean isWithin(int row, int col, int row1, int col1, int row2, int col2) {
        if (row < row1 || row > row2) {
            return false;
        }

        if (col < col1 || col > col2) {
            return false;
        }

        return true;
    }

    private boolean isOverlap(int row1, int col1, int row2, int col2,
                              int rowA1, int colA1, int rowA2, int colA2) {

        if (row2 < rowA1 || rowA2 < row1) {
            return false;
        }

        if (col2 < colA1 || colA2 < col1) {
            return false;
        }

        return true;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return sumRegion(row1, col1, row2, col2, 0, 0, rowC - 1, colC - 1, 0);
    }

    private int sumRegion(int row1, int col1, int row2, int col2,
                          int rowL1, int colL1, int rowU2, int colU2, int position) {

        if (rowL1 > rowU2 || colL1 > colU2) {
            return 0;
        }

        if (!isOverlap(row1, col1, row2, col2, rowL1, colL1, rowU2, colU2)) {
            return 0;
        }

        if (row1 <= rowL1 && rowU2 <= row2 && col1 <= colL1 && colU2 <= col2) {
            return tree[position];
        }

        int midRow = (rowL1 + rowU2) / 2;
        int midCol = (colL1 + colU2) / 2;

        return sumRegion(row1, col1, row2, col2, rowL1, colL1, midRow, midCol, 4 * position + 1)
                + sumRegion(row1, col1, row2, col2, rowL1, midCol + 1, midRow, colU2, 4 * position + 2)
                + sumRegion(row1, col1, row2, col2, midRow + 1, colL1, rowU2, midCol, 4 * position + 3)
                + sumRegion(row1, col1, row2, col2, midRow + 1, midCol + 1, rowU2, colU2, 4 * position + 4);
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
//        int[][] matrix = {
//                {3, 0, 1, 4, 2},
//                {5, 6, 3, 2, 1},
//                {1, 2, 0, 1, 5},
//                {4, 1, 0, 1, 7},
//                {1, 0, 3, 0, 5}
//        };

        RangeSumQuery2DMutable r = new RangeSumQuery2DMutable(matrix);

//        r.sumRegion(2, 1, 4, 3);
//
//        r.update(3, 2, 2);
//
//        r.sumRegion(2, 1, 4, 3);

        int i = r.sumRegion(2, 1, 4, 3);

        r.update(3, 2, 2);

        int i1 = r.sumRegion(2, 1, 4, 3);

        int a = 1;
    }

}
