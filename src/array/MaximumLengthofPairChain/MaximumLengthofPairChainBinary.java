package array.MaximumLengthofPairChain;

import java.util.Arrays;

/**
 * Created by tianle on 3/25/18.
 */
public class MaximumLengthofPairChainBinary {

    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));

        int length = pairs.length;

        int[] minRight = new int[length + 1];
        int lastEvaludatedIndex = 1;
        minRight[1] = pairs[0][1];

        for (int i = 1; i < length; i++) {
            int index = Arrays.binarySearch(minRight, 1, lastEvaludatedIndex + 1, pairs[i][0]);

            if (index < 0) {
                index = -(index + 1);
            }

            if (index > lastEvaludatedIndex) {
                lastEvaludatedIndex = index;
                minRight[lastEvaludatedIndex] = pairs[i][1];
            } else {
                minRight[index] = Math.min(minRight[index], pairs[i][1]);
            }
        }

        return lastEvaludatedIndex;
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

        MaximumLengthofPairChainBinary dp = new MaximumLengthofPairChainBinary();

        System.out.println(dp.findLongestChain(dp.test1()));
    }
}
