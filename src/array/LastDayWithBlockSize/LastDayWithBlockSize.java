package array.LastDayWithBlockSize;

/**
 * Created by tianle on 2/23/18.
 */
public class LastDayWithBlockSize {

    /**
     * operates on virtual array value[]
     *
     * @param schedule permutation of 1 to N, indicates on day i, value[schedule[i]] is 1
     * @param k
     * @return
     */
    public int lastDay(int[] schedule, int k) {

        int length = schedule.length;
        int[] value = new int[length + 1];

        int lastDay = -1;

        for (int i = 0; i < length; i++) {

            value[schedule[i]] = 1;
            boolean hasSize = hasSize(value, length, k);

//            System.out.println(Arrays.toString(value) + ", result is " + hasSize);

            if (hasSize) {
                lastDay = Math.max(lastDay, i);
            }
        }

        return lastDay;
    }

    private boolean hasSize(int[] value, int length, int k) {

        int currentSize = 0;

        for (int i = 1; i <= length; i++) {

            if (value[i] == 0) {
                if (currentSize == k) {
                    return true;
                }

                currentSize = 0;
            } else {
                currentSize++;
            }
        }

        return currentSize == k;
    }

    public static void main(String[] args) {

        LastDayWithBlockSize d = new LastDayWithBlockSize();

        int[] ints = {3, 1, 5, 4, 2};
        int k = 1;

        System.out.println(d.lastDay(ints, k));
    }
}
