package array.LastDayWithBlockSize;

import utils.PermutationUtil;

/**
 * Created by tianle on 2/24/18.
 */
public class LastDayWithBlockSizeSlidingWindow {
    public int lastDay(int[] schedule, int k) {
        int length = schedule.length;

        if (k == length) {
            return length - 1;
        }

        int[] days = new int[length + 2];

        /*
        * schedule index from 0, 1, 2, ..n-1.
        * days index from 1, 2, 3, n
        * */
        for (int i = 0; i < length; i++) {
            days[schedule[i]] = i;
        }

        days[0] = Integer.MAX_VALUE;
        days[length + 1] = Integer.MAX_VALUE;

        int right = length + 1;
        int left = right - k - 1;

        int i = right - 1;

        int latestDay = -1;

        while (left >= 0) {
            if (days[i] < days[left] && days[i] < days[right]) {
                // current i meets our requirement
                if (i == left + 1) {
                    int lastDay = Math.min(days[left], days[right]) - 1;
                    latestDay = Math.max(lastDay, latestDay);

                    right = left;
                    left = right - k - 1;
                    i = right - 1;
                } else {
                    // i hasn't reached the end yet.
                    i--;
                }
            } else {
                // i doesn't meet the requirement.
                right = i;
                left = right - k - 1;
                i = right - 1;
            }
        }

        return latestDay;
    }

    public void loadTest() {
        //get test data
        int n = 99999999;

        int[] permutation = PermutationUtil.permutation(n);
        int k = 1000;

        System.out.println("Finish permutation test data");

        LastDayWithBlockSizeSlidingWindow smart = new LastDayWithBlockSizeSlidingWindow();
        LastDayWithBlockSizeTreeSet littleSmart = new LastDayWithBlockSizeTreeSet();

        long start = System.currentTimeMillis();

        System.out.println(smart.lastDay(permutation, k));

        long end = System.currentTimeMillis();

        System.out.println("Smart takes " + (end - start) * 1.0 / 1000 + " seconds");

        start = System.currentTimeMillis();

        System.out.println(littleSmart.lastDay(permutation, k));

        end = System.currentTimeMillis();

        System.out.println("littleSmart takes " + (end - start) * 1.0 / 1000 + " seconds");

//        start = System.currentTimeMillis();
//
//        System.out.println(naive.lastDay(permutation, k));
//
//        end = System.currentTimeMillis();
//
//        System.out.println("Naive takes " + (end - start) * 1.0 / 1000 + " seconds");
    }

    public static void main(String[] args) {

        LastDayWithBlockSizeSlidingWindow d = new LastDayWithBlockSizeSlidingWindow();

        int[] ints = {3, 1, 5, 4, 2};
        int k = 1;

        System.out.println(d.lastDay(ints, k));

        d.loadTest();
    }
}
