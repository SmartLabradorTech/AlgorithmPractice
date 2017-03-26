package array.Combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianle on 3/25/17.
 */
public class DistinctIntegers {

    // print all combinations of given list of integers. Input has no duplications.

    public void print(List<Integer> input) {
        if (input == null || input.isEmpty()) {
            return;
        }

        System.out.println("Going to print all permutation of " + input);

        List<Integer> combination = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            print(input, combination, 0, i + 1);
        }
    }

    private void print(List<Integer> input, List<Integer> current, int start, int neededLength) {
        if (0 == neededLength) {
            System.out.println(current);
            return;
        }

        if (start == input.size()) {
            return;
        }

        // use it
        current.add(input.get(start));
        print(input, current, start + 1, neededLength - 1);

        current.remove(current.size() - 1);

        print(input, current, start + 1, neededLength);
    }

    public static void main(String[] args) {
        DistinctIntegers distinctIntegers = new DistinctIntegers();
        distinctIntegers.print(Arrays.asList(1));

        distinctIntegers.print(Arrays.asList(1, 2));

        distinctIntegers.print(Arrays.asList(1, 2, 3));

    }
}
