package array.LastDayWithBlockSize;

import utils.PermutationUtil;

import java.util.TreeSet;

/**
 * Created by tianle on 2/24/18.
 */
public class LastDayWithBlockSizeTreeSet {
    public int lastDay(int[] schedule, int k) {

        int length = schedule.length;

        if (k == length) {
            return length - 1;
        }

        TreeSet<Integer> set = new TreeSet<>();

        set.add(0);
        set.add(length + 1);

        for (int i = length - 1; i >= 0; i--) {

            int location = schedule[i];

            Integer ceiling = set.ceiling(location + 1);
            Integer floor = set.floor(location - 1);

            if (location - floor - 1 == k || ceiling - location - 1 == k) {
                return i - 1;
            }

            set.add(location);
        }

        return -1;
    }

    public static void main(String[] args) {

        LastDayWithBlockSizeTreeSet d = new LastDayWithBlockSizeTreeSet();

        int[] ints = {3, 1, 5, 4, 2};
        int k = 3;

//        System.out.println(d.lastDay(ints, k));

        //get test data
        int n = 100000;

        int[] permutation = PermutationUtil.permutation(n);
        k = 100;

        System.out.println("Finish permutation test data");

        LastDayWithBlockSize naive = new LastDayWithBlockSize();
        LastDayWithBlockSizeTreeSet smart = new LastDayWithBlockSizeTreeSet();

        long start = System.currentTimeMillis();

        System.out.println(smart.lastDay(permutation, k));

        long end = System.currentTimeMillis();

        System.out.println("Smart takes " + (end - start) * 1.0 / 1000 + " seconds");

        start = System.currentTimeMillis();

        System.out.println(naive.lastDay(permutation, k));

        end = System.currentTimeMillis();

        System.out.println("Naive takes " + (end - start) * 1.0 / 1000 + " seconds");
    }
}
