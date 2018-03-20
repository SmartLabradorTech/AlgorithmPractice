package permutation;

/**
 * Created by tianle on 3/8/18.
 */
public class PermutationRecursive {

    public void permute(int[] nums) {

    }

    private void permute(int[] nums, int startIndex) {

    }

    private void swap(int[] nums, int a, int b) {
        if (a != b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
}
