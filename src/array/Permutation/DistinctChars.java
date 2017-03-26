package array.Permutation;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tianle on 3/25/17.
 */
public class DistinctChars {

    // given a string consisted of distinct chars, print all the possible permutations

    public void print(List<Integer> input) {

        if (input == null || input.isEmpty()) {
            return;
        }

        System.out.println("Going to print all permutation of " + input);

        print(input, 0);
    }

    private void print(List<Integer> input, int startIndex) {

        if (startIndex == input.size()) {
            System.out.println(input);
            return;
        }

        int i;
        for (i = startIndex; i < input.size(); i++) {
            swap(input, i, startIndex);

            // no matter what i is, we always move start point to next one based on current start
            int newStart = startIndex + 1;

            print(input, newStart);

            swap(input, i, startIndex);
        }

    }

    private void swap(List<Integer> input, int i, int j) {

        int temp = input.get(i);
        input.set(i, input.get(j));

        input.set(j, temp);
    }

    public static void main(String[] args) {
        DistinctChars distinctChars = new DistinctChars();

        distinctChars.print(Arrays.asList(1, 2, 3, 4));

        distinctChars.print(Arrays.asList(1, 2, 3));

        distinctChars.print(Arrays.asList(1, 2));

        distinctChars.print(Arrays.asList(1));
    }
}
