package strings.LongestPalindromicSubstring;

public class LongestPalindromicSubstringV4 {

    // try DP

    //this takes too much time as it uses substring length as driver
    public String longestPalindrome(String s) {

        int length = s.length();

        boolean[][] result = new boolean[length][length];

        int start = 0;
        int end = 0;

        for (int i = 0; i < length; i++) {
            result[i][i] = true;

            if (i + 1 < length) {
                result[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));

                if (result[i][i + 1]) {
                    start = i;
                    end = i + 1;
                }
            }
        }

        // result[i][j] depends on result[i+1][j-1]. Thus we need a way to push the results to be filled. Length could be such driver.
        for (int size = 3; size <= length; size++) {
            for (int i = 0; i < length; i++) {
                for (int j = i + size - 1; j < length; j++) {
                    result[i][j] = result[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));

                    if (result[i][j]) {
                        start = i;
                        end = j;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public String longestPalindromeImproved(String s) {

        int start = 0;
        int end = 0;

        int max = 1;

        int length = s.length();

        boolean[][] result = new boolean[length][length];

        for (int j = 0; j < length; j++) {

            for (int i = 0; i <= j; i++) {

                boolean equal = s.charAt(i) == s.charAt(j);

                if (j - i <= 1) {
                    result[i][j] = equal;
                } else {
                    result[i][j] = result[i + 1][j - 1] && equal;
                }

                if (result[i][j] && (j - i + 1 > max)) {
                    max = j - i + 1;
                    start = i;
                    end = j;
                }

            }

        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {

        LongestPalindromicSubstringV4 lv4 = new LongestPalindromicSubstringV4();

        String s = "cbbd";

        System.out.println(lv4.longestPalindromeImproved(s));
    }
}
