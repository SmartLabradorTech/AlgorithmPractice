package number.LargestNumber;

import java.util.Comparator;

/**
 * Created by tianleh on 10/24/16.
 */

class SpeComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        String first = o1.toString();
        String second = o2.toString();

        for (int i = 0; ; i++) {
            if (i >= first.length()) {
                if (i >= second.length()) {
                    return 0;
                }

                return 1;
            }

            if (i >= second.length()) {
                return -1;
            }

            if (first.charAt(i) > second.charAt(i)) {
                return 1;
            }

            if (first.charAt(i) < second.charAt(i)) {
                return -1;
            }

        }
    }
}

public class LargestNumber {

    public String largestNumber(int[] nums) {

        int length = nums.length;

        //Arrays.sort(nums, new SpeComparator());

        String result = "";

        return result;
    }

    public static void main(String[] args) {
        int[] input = {3, 30, 34, 5, 9};

        LargestNumber largestNumber = new LargestNumber();

        System.out.println(largestNumber.largestNumber(input));
    }
}

