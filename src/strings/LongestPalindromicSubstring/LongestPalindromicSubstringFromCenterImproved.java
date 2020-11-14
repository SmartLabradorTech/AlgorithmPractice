package strings.LongestPalindromicSubstring;

public class LongestPalindromicSubstringFromCenterImproved {

    // V3 solved the problem by expanding from center. However, it has complicated logic for the length calculation.
    // We can clean it up by returning the substring directly from the expand function.
    public String longestPalindrome(String s) {

        int max = 0;
        String result = "";

        for (int i = 0; i < s.length(); i++) {

            String extendAsSingleCenter = extend(i, i, s);

            if (extendAsSingleCenter.length() > max) {
                max = extendAsSingleCenter.length();
                result = extendAsSingleCenter;
            }

            String extendAsDoubleCenters = extend(i, i + 1, s);

            if (extendAsDoubleCenters.length() > max) {
                max = extendAsDoubleCenters.length();
                result = extendAsDoubleCenters;
            }
        }

        return result;
    }


    // previously the edge case was handled in a complicated. Just think in this way. If it leaves the while loop, this means
    // either the array boundary has exceeds or the equal check fails.
    // If the boundary has exceeds, this means that the previous iteration has the correct result. [start+1, end)
    // if the equals check fails, typically it has the same implication as above. But one edge is the initial iteration.
    // What if the input is ['a', 'b']. It will fail the equal check in the first run. Then does the shrinking to previous result still work?
    // The answer is yes!!! In this case, start=0, end=1. The return will be [1,1). The substring function can take care of this and return empty.
    private String extend(int start, int end, String s) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return s.substring(start + 1, end);
    }

    public static void main(String[] args) {

        LongestPalindromicSubstringV3 lv3 = new LongestPalindromicSubstringV3();

        String s = "cbbd";

        System.out.println(lv3.longestPalindrome(s));

//        System.out.println(s.substring(2, 1));
    }
}
