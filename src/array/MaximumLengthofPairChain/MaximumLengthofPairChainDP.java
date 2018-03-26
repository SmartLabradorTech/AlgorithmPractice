package array.MaximumLengthofPairChain;

import java.util.Arrays;

/**
 * Created by tianle on 3/24/18.
 * <p>
 * https://leetcode.com/problems/maximum-length-of-pair-chain/description/#
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

        int length = pairs.length;

        // it means if current interval is included, what is the max
        int[] tillNow = new int[length];
        tillNow[0] = 1;

        int max = 1;

        for (int i = 1; i < length; i++) {
            int left = pairs[i][0];
            int right = pairs[i][1];

            int maxSoFar = 0;

            for (int j = 0; j < i; j++) {
                if (left > pairs[j][1]) {
                    maxSoFar = Math.max(maxSoFar, tillNow[j]);
                }
            }

            maxSoFar++;

            max = Math.max(max, maxSoFar);

            tillNow[i] = maxSoFar;
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

    private int[][] test2() {
        int[][] input = {
                {1, 2},
                {2, 3},
                {3, 4}
        };

        return input;
    }

    public static void main(String[] args) {

        MaximumLengthofPairChainDP dp = new MaximumLengthofPairChainDP();

        System.out.println(dp.findLongestChain(dp.test2()));
    }
}
