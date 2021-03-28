package strings.LongestPalindromicSubstring;

public class LongestPalindromicSubstringDPV2 {

    //V4 has a dp solution but it needs some improvement.

    public String longestPalindrome(String s) {
        int length = s.length();

        boolean[][] result = new boolean[length][length];

        int max = 0;
        String string = "";

        for (int size = 1; size <= length; size++) {

            for (int i = 0; i + size - 1 < length; i++) {
                boolean equal = s.charAt(i) == s.charAt(i + size - 1);

                if (size <= 2) {
                    result[i][i + size - 1] = equal;
                } else {
                    result[i][i + size - 1] = result[i + 1][i + size - 2] && equal;
                }

                if (result[i][i + size - 1] && size > max) {
                    max = size;
                    string = s.substring(i, i + size);
                }
            }
        }

        return string;
    }

    public static void main(String[] args) {

        LongestPalindromicSubstringDPV2 lv3 = new LongestPalindromicSubstringDPV2();

        String s = "cbbd";

        System.out.println(lv3.longestPalindrome(s));
    }
}
