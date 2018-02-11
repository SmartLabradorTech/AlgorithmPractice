package array.ReverseArray;

import java.util.Arrays;

/**
 * Created by tianle on 2/8/18.
 */
public class ReverseArray {

    public int[] reverse(int[] input) {
        int length = input.length;

        int start = 0;
        int end = length - 1;

        while (start <= end) {
            swap(input, start, end);
            start++;
            end--;
        }

        return input;
    }

    private void swap(int[] input, int start, int end) {
        int temp = input[start];

        input[start] = input[end];
        input[end] = temp;
    }

    public static void main(String[] args) {
        ReverseArray r = new ReverseArray();

//        int[] input = {1, 2, 3, 4, 5};

        int[] input = {1, 2, 3, 4};

        System.out.println(Arrays.toString(r.reverse(input)));
    }
}
