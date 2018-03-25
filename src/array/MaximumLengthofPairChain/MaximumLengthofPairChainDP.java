package array.MaximumLengthofPairChain;

import java.util.Arrays;

/**
 * Created by tianle on 3/24/18.
 *
 * doesn't work
 */
public class MaximumLengthofPairChainDP {
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> {
            int diff = a[0] - b[0];

            if (diff == 0) {
                return a[1] - b[1];
            }

            return diff;
        });

        int max = 1;

        int rightBoundary = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > rightBoundary) {
                max++;
                rightBoundary = pairs[i][1];
            }
        }

        return max;
    }

    private int[][] test1() {
        // [[-6,9],[1,6],[8,10],[-1,4],[-6,-2],[-9,8],[-5,3],[0,3]]
        int[][] ints = {
                {-6, 9},
                {1, 6},
                {8, 10},
                {-1, 4},
                {-6, -2},
                {-9, 8},
                {-5, 3},
                {0, 3}
        };

        return ints;
    }

    public static void main(String[] args) {

        MaximumLengthofPairChainDP dp = new MaximumLengthofPairChainDP();

        int[][] input = {
                {1, 2},
                {2, 3},
                {3, 4}
        };

        System.out.println(dp.findLongestChain(dp.test1()));
    }
}
