package strings.LongestPalindromicSubstring;

public class LongestPalindromicSubstringV2 {

    public String longestPalindrome(String s) {

        int max = 1;
        String result = "";
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            // if current itself is the center

            int currentMax = 1;

            for (int j = 1; ; j++) {
                if (i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j)) {
                    currentMax += 2;

                    if (currentMax > max) {
                        max = currentMax;
                        start = i - j;
                        end = i + j;
                    }
                } else {
                    break;
                }
            }

            System.out.println("I am at index " + i + ", my first max is " + currentMax + " from " + start + " to " + end);

            // try to see if i, i+1 together forms a center
            currentMax = 0;

            for (int k = 0; (i - k >= 0) && (i + 1 + k) < s.length(); k++) {

                if (s.charAt(i - k) == s.charAt(i + 1 + k)) {
                    currentMax += 2;

                    if (currentMax > max) {
                        max = currentMax;
                        start = i - k;
                        end = i + 1 + k;
                    }
                } else {
                    break;
                }

            }

            System.out.println("I am at index " + i + ", my second max is " + currentMax + " from " + start + " to " + end);

        }

        return s.substring(start, end + 1);
    }


    public static void main(String[] args) {

        LongestPalindromicSubstringV2 lp = new LongestPalindromicSubstringV2();

        String input = "babad";

        System.out.println(lp.longestPalindrome(input));
    }
}
