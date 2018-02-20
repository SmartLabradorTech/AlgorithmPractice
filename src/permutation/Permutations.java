package permutation;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tianle on 2/10/18.
 * https://leetcode.com/problems/permutations/description/
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        return permute(nums, 0);
    }

    private List<List<Integer>> permute(int[] nums, int start) {
        if (start == nums.length - 1) {
            return Arrays.asList(Arrays.asList(nums[start]));
        }

        List<List<Integer>> permutes = permute(nums, start + 1);

        for (List<Integer> each : permutes) {
            each.add(0, nums[start]);
        }

        return permutes;
    }
}
