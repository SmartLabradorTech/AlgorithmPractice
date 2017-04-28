package array.Combination;

import java.util.*;

/**
 * Created by tianle on 3/26/17.
 */
public class DuplicatedIntegers {

    // print all combinations of given list of integers. Input may have duplications.

    public void print(List<Integer> input) {
        if (input == null || input.isEmpty()) {
            return;
        }

        System.out.println("Going to print all combination of " + input);

        Map<Integer, Integer> occur = new HashMap<>();

        for (Integer element : input) {
            Integer times = occur.getOrDefault(element, 0);
            occur.put(element, ++times);
        }

        List<Integer> combination = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            print(input, combination, 0, i + 1);
        }
    }

    private void print(List<Integer> input,
                       List<Integer> current,
                       int start, int neededLength) {
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

        distinctIntegers.print(Arrays.asList(1, 1));

        distinctIntegers.print(Arrays.asList(1, 2, 2));

    }
}
