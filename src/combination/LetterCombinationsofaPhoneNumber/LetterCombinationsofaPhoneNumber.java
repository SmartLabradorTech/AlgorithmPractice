package combination.LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by tianle on 12/28/17.
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinationsofaPhoneNumber {

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        List<String> from = from(0, digits);

//        System.out.println(from);

        return from;
    }

    private List<String> from(int start, String digits) {
        if (start == digits.length()) {
            return Arrays.asList("");
        }

        char currentDigit = digits.charAt(start);
        String key = KEYS[currentDigit - '0'];

        List<String> output = new ArrayList<>();

        List<String> fromLater = from(start + 1, digits);

        for (int i = 0; i < key.length(); i++) {
            for (int j = 0; j < fromLater.size(); j++) {
                output.add(key.charAt(i) + fromLater.get(j));
            }
        }

        return output;
    }

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber n = new LetterCombinationsofaPhoneNumber();

//        String input = "23";
        String input = "";

        n.letterCombinations(input);
    }
}
