package array.Permutation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tianle on 3/25/17.
 */
public class DuplicatedChars {

    // given a string consisted of chars which may have duplications, print all the possible permutations

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

        Set<Integer> swapped = new HashSet<>();

        for (i = startIndex; i < input.size(); i++) {

            if (swapped.contains(input.get(i))) {
                // already handled
                continue;
            }

            swapped.add(input.get(i));

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
        DuplicatedChars distinctChars = new DuplicatedChars();

        distinctChars.print(Arrays.asList(1, 2, 2, 4));

        distinctChars.print(Arrays.asList(1, 2, 3));

        distinctChars.print(Arrays.asList(1, 2));

        distinctChars.print(Arrays.asList(1, 1));

        distinctChars.print(Arrays.asList(1, 3, 3));
    }
}
