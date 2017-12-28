package array.RemoveDuplicateLetters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by tianle on 12/25/17.
 * https://leetcode.com/problems/remove-duplicate-letters/description/
 */
public class RemoveDuplicateLetters {

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

        List<Character> result = new ArrayList<>();
        char firstChar = s.charAt(0);
        result.add(firstChar);
        counts.put(firstChar, counts.get(firstChar) - 1);
        visited.add(firstChar);

        for (int i = 1; i < length; i++) {

            char currentChar = s.charAt(i);

            if (visited.contains(currentChar)) {
                counts.put(currentChar, counts.get(currentChar) - 1);

                continue;
            }

            for (int j = result.size() - 1; j >= 0; j--) {
                char previousChar = result.get(j);

                if (counts.get(previousChar) == 0) {
                    break;
                }

                if (previousChar > currentChar) {
                    result.remove(j);
                    visited.remove(previousChar);
                }
            }

            result.add(currentChar);
            counts.put(currentChar, counts.get(currentChar) - 1);
            visited.add(currentChar);
        }

        String r = "";

        for (Character c : result) {
            r += c;
        }

        return r;
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters r = new RemoveDuplicateLetters();

//        String input = "cbacdcbc";
//        String input = "aabbcc";

        String input = "bbcaac";
        System.out.println(r.removeDuplicateLetters(input));

    }
}
