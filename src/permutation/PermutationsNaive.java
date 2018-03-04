package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianle on 2/10/18.
 * https://leetcode.com/problems/permutations/description/
 */
public class PermutationsNaive {

    public List<List<Integer>> permute(int[] nums) {

        return permute(nums, 0);
    }

    private List<List<Integer>> permute(int[] nums, int start) {
        if (start == nums.length - 1) {
            List<Integer> objects = new ArrayList<>();
            objects.add(nums[start]);
            return Arrays.asList(objects);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = start; i < nums.length; i++) {
            int[] ints = Arrays.copyOfRange(nums, 0, nums.length);
            swap(ints, start, i);

            List<List<Integer>> permute = permute(ints, start + 1);

            for (List<Integer> p : permute) {
                p.add(0, ints[start]);
                result.add(p);
            }

        }

        return result;
    }

    private void swap(int[] ints, int a, int b) {
        if (a != b) {
            int temp = ints[a];
            ints[a] = ints[b];
            ints[b] = temp;
        }
    }

    public void print(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static void main(String[] args) {
        PermutationsNaive p = new PermutationsNaive();

        int[] ints = {1, 2, 3};

        p.print(p.permute(ints));
    }
}
