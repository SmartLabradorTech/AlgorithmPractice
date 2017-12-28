package array.RemoveDuplicateLetters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by tianle on 12/28/17.
 * * https://leetcode.com/problems/remove-duplicate-letters/description/
 * <p>
 * Since we need to look at previous result to find a good location for current char, it implies a stack data structure.
 */
public class RemoveDuplicateLettersStack {

    public String removeDuplicateLetters(String s) {
        if (s == null) {
            return null;
        }

        if (s.length() == 0) {
            return s;
        }

        Map<Character, Integer> counts = new HashMap<>();

        int length = s.length();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            int currentCount = counts.getOrDefault(c, 0);

            counts.put(c, currentCount + 1);
        }

        Set<Character> visited = new HashSet<>();

        Stack<Character> result = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            counts.put(currentChar, counts.get(currentChar) - 1);

            if (visited.contains(currentChar)) {
                continue;
            }

            while (!result.empty()) {
                Character peekChar = result.peek();

                if (peekChar < currentChar) {
                    break;
                }

                if (counts.get(peekChar) == 0) {
                    break;
                }

                result.pop();
                visited.remove(peekChar);
            }

            // add current char
            result.push(currentChar);
            visited.add(currentChar);
        }

        String resultString = "";

        while (!result.isEmpty()) {
            resultString = result.pop() + resultString;
        }

        return resultString;
    }

    public static void main(String[] args) {
        RemoveDuplicateLettersStack r = new RemoveDuplicateLettersStack();

        String input = "cbacdcbc";
//        String input = "aabbcc";

//        String input = "bbcaac";
        System.out.println(r.removeDuplicateLetters(input));

    }
}
