package combination.LetterCombinationsofaPhoneNumber;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tianle on 12/30/17.
 * <p>
 * learnt from https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8064
 */
public class LetterCombinationsofaPhoneNumberLearnedQueue {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumberLearnedQueue n = new LetterCombinationsofaPhoneNumberLearnedQueue();

//        String input = "23";
        String input = "";

        System.out.println(n.letterCombinations(input));
    }
}
