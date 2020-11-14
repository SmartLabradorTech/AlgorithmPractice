package strings.LongestPalindromicSubstring;

public class LongestPalindromicSubstringV3 {

    public String longestPalindrome(String s) {

        int max = 1;
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            int extendAsSingleCenter = extend(i - 1, i + 1, s);

            int extendAsDoubleCenters = extend(i, i + 1, s);

            int maxCurrent = Math.max(extendAsDoubleCenters * 2, 1 + extendAsSingleCenter * 2);

            if (maxCurrent <= max) {
                continue;
            }

            max = maxCurrent;

            if (extendAsSingleCenter * 2 + 1 > extendAsDoubleCenters * 2) {
                start = i - extendAsSingleCenter;
                end = i + extendAsSingleCenter;
            } else {
                start = i - (extendAsDoubleCenters - 1);
                end = i + 1 + (extendAsDoubleCenters - 1);
            }
        }

        return s.substring(start, end + 1);
    }


    private int extend(int start, int end, String s) {
        int k = 0;

        while (start - k >= 0 && end + k < s.length() && s.charAt(start - k) == s.charAt(end + k)) {
            k++;
        }

        return k;
    }

    public static void main(String[] args) {

        LongestPalindromicSubstringV3 lv3 = new LongestPalindromicSubstringV3();

        String s = "cbbd";

        System.out.println(lv3.longestPalindrome(s));
    }
}
