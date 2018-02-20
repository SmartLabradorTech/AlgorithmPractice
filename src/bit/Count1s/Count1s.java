package bit.Count1s;

/**
 * Created by tianle on 2/19/18.
 */
public class Count1s {

    //return number of concecutive number of 1s
    private static int maxConsecutiveOnes(int x) {
        // Initialize result
        int count = 0;

        // Count the number of iterations to
        // reach x = 0.
        while (x != 0) {
            // This operation reduces length
            // of every sequence of 1s by one.
            x = (x & (x << 1));

            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Count1s count1s = new Count1s();

        System.out.println(count1s.maxConsecutiveOnes(12));
    }
}
