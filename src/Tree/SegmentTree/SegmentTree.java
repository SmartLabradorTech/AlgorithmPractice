package Tree.SegmentTree;

import java.util.Arrays;

/**
 * Created by tianle on 10/13/17.
 */
public class SegmentTree {

    /**
     * This function will build a segment tree represented in an array.
     *
     * @param input
     * @return
     */
    public int[] build(int[] input) {
        int length = input.length;

        int[] target = new int[2 * length];

        build(input, target, 0, length - 1, 0);

        return target;
    }

    private int build(int[] input, int[] target, int start, int end, int current) {
        if (start == end) {
            target[current] = input[start];
            return input[start];
        }

        int mid = (start + end) / 2;

        target[current] = Math.min(
                build(input, target, start, mid, 2 * current + 1),
                build(input, target, mid + 1, end, 2 * current + 2)
        );

        return target[current];
    }

    public static void main(String[] args) {
        int[] ints = {-1, 2, 4, 0};

        SegmentTree st = new SegmentTree();

        int[] build = st.build(ints);

        System.out.println(Arrays.toString(build));
    }
}
