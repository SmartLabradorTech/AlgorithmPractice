package array.CalculateWindowSums;

import java.util.Arrays;

/**
 * Created by tianle on 10/19/17.
 */
public class CalculateWindowSums {


    public int[] calculateWindowSums(int[] ints, int k) {

        int length = ints.length;

        int[] sums = new int[length - k + 1];

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += ints[i];

            sums[0] = sum;
        }

        for (int i = k; i < length; i++) {
            sums[i - k + 1] = sums[i - k] + ints[i] - ints[i - k];
        }

        return sums;
    }

    public int[] calculateWindowSums2(int[] ints, int k) {

        int length = ints.length;

        int[] sums = new int[length - k + 1];

        int sum = 0;

        for (int i = 0; i < length; i++) {

            sum += ints[i];

            if (i >= k - 1) {
                sums[i - k + 1] = sum;
                sum -= ints[i - k + 1];
            }
        }

        return sums;
    }

    public static void main(String[] args) {

        CalculateWindowSums c = new CalculateWindowSums();

        int[] ints = {1, 10, 100, 1000, 10000};

        System.out.println(Arrays.toString(c.calculateWindowSums2(ints, 2)));
    }
}
