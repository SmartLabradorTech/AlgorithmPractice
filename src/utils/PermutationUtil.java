package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tianle on 2/24/18.
 */
public class PermutationUtil {

    public static int[] permutation(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        return list.stream().mapToInt(i -> i).toArray();
    }
}
