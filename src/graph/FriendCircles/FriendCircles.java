package graph.FriendCircles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tianle on 3/19/18.
 * https://leetcode.com/problems/friend-circles/description/
 * <p>
 * This version will time out!!!!
 */
public class FriendCircles {
    private Set<Integer> allNumbers;

    public int findCircleNum(int[][] M) {

        Set<Integer> set = new HashSet<>();

        allNumbers = new HashSet<>();

        int length = M.length;

        for (int i = 0; i < length; i++) {
            allNumbers.add(i);
        }

        int count = 0;

        while (!allNumbers.isEmpty()) {
            System.out.println("start round " + count);

            Integer next = allNumbers.iterator().next();
            dfs(M, next, set);

            count++;
        }

        System.out.println("Finish calculating...");

        return count;
    }

    public void dfs(int[][] M, int start, Set<Integer> path) {
        path.add(start);

        allNumbers.remove(start);

        for (int i = 0; i < M.length; i++) {
            if (!path.contains(i) && start != i && M[start][i] == 1) {
                dfs(M, i, path);
                printSet(path);
                path.remove(start);
            }
        }
    }

    private void printSet(Set<Integer> path) {
        List<Integer> a = new ArrayList<>(path);
        System.out.println(Arrays.toString(a.toArray()));
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

        FriendCircles friendCircles = new FriendCircles();

        int circleNum = friendCircles.findCircleNum(friendCircles.test());

        System.out.println(circleNum);
    }
}
