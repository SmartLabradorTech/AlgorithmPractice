package graph.FriendCircles;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by tianle on 3/22/18.
 */
public class FriendCirclesUnionFind {

    public int findCircleNum(int[][] M) {

        int length = M.length;

        int[] groups = new int[length];

        for (int i = 0; i < length; i++) {
            groups[i] = i;
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (M[i][j] == 1) {
                    int first = groups[i];
                    int second = groups[j];

                    if (first == second) {
                        continue;
                    }

                    int newGroup = Math.min(first, second);

                    for (int k = 0; k < length; k++) {
                        if (groups[k] == first || groups[k] == second) {
                            groups[k] = newGroup;
                        }
                    }
                }
            }
        }

        return Arrays.stream(groups).boxed().collect(Collectors.toSet()).size();
    }

    private int[][] test() {
        int[][] M = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        return M;
    }

    private int[][] test2() {
        int[][] M = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };

        return M;
    }

    public static void main(String[] args) {

        FriendCirclesUnionFind friendCircles = new FriendCirclesUnionFind();

        int circleNum = friendCircles.findCircleNum(friendCircles.test());

        System.out.println(circleNum);
    }
}
