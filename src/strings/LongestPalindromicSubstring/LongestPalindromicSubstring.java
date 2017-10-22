package strings.LongestPalindromicSubstring;

import java.util.PriorityQueue;
import java.util.zip.Inflater;

/**
 * Created by tianle on 10/20/17.
 */
public class LongestPalindromicSubstring {

    public String longestPalindromicSubstring(String s) {

        int length = s.length();

        boolean[][] is = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            is[i][i] = true;
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (j == i + 1) {
                    is[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    is[i][j] = (s.charAt(i) == s.charAt(j)) && is[i - 1][j - 1];
                }
            }
        }

        PriorityQueue<Integer> a = new PriorityQueue<>();



        return null;
    }
}
