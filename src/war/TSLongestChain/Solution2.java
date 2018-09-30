package war.TSLongestChain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tianle on 3/26/18.
 */
public class Solution2 {

    public int longestChain(String[] words) {
        // perform input validation.
        if (words == null) {
            return 0;
        }

        int length = words.length;

        if (length == 0) {
            return 0;
        }

        int longestChain = 0;
        Arrays.sort(words, (str1, str2) -> str1.length() - str2.length());

        // remember the max chain of each word
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (map.containsKey(word)) {
                continue;
            }

            map.put(word, 1);

            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String after = sb.toString();
                if (map.containsKey(after) && map.get(after) + 1 > map.get(word)) {
                    map.put(word, map.get(after) + 1);
                }
            }

            if (map.get(word) > longestChain) longestChain = map.get(word);
        }

        return longestChain;
    }

    private String[] input1() {

        String[] input = {
                "a", "and", "an", "bear"
        };

        return input;
    }

    public static void main(String[] args) {

        Solution2 s = new Solution2();

        System.out.println(s.longestChain(s.input1()));
    }
}
