package number.NthDigit;

/**
 * Created by tianleh on 10/8/16.
 * <p>
 * https://leetcode.com/problems/nth-digit/
 */
public class NthDigit {

    public int findNthDigit(int n) {

        int p = 0;

        int sum = 0;
        int nextSum = 0;

        while (n > nextSum) {

            sum = nextSum;

            double delta = 9 * Math.pow(10, p) * (p + 1);

            nextSum += delta;

            p++;
        }

        p--;

        int missing = n - sum;

        if (missing == 0) {
            return getLast((int) (Math.pow(10, p + 1) - 1));
        }

        int which = missing / (p + 1);

        int moreMissing = missing - (p + 1) * which;

        if (moreMissing == 0) {
            return getLast((int) Math.pow(10, p) + which - 1);
        }

        return getDigitInNumber((int) Math.pow(10, p) + which, moreMissing);
    }

    private int getLast(int number) {
        String s = String.valueOf(number);
        return getDigitInNumber(number, s.length());
    }

    private int getDigitInNumber(int number, int index) {
        String s = String.valueOf(number);

        char c = s.charAt(index - 1);

        return Character.getNumericValue(c);
    }

    public static void main(String[] args) {
        NthDigit nthDigit = new NthDigit();

        System.out.println(nthDigit.findNthDigit(100));
    }
}
