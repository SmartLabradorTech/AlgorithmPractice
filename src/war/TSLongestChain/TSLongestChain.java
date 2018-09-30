package war.TSLongestChain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by tianle on 3/26/18.
 */
public class TSLongestChain {

    private static int currentMax = 0;

    static int longestChain(String[] words) {

        // perform input validation.
        if (words == null) {
            return 0;
        }

        int length = words.length;

        if (length == 0) {
            return 0;
        }

        Arrays.sort(words, (s1, s2) -> (s1.length() - s2.length()));

        //remember the longest chain of a string to avoid duplicated computing.
        Map<String, Integer> resultsSoFar = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int chainLength = chainLength(words[i], words, resultsSoFar);
            currentMax = Math.max(currentMax, chainLength);
        }

        return currentMax;
    }

    private static int chainLength(String target, String[] words, Map<String, Integer> resultsSoFar) {

        if (resultsSoFar.containsKey(target)) {
            return resultsSoFar.get(target);
        }

        int length = target.length();

        if (length == 1) {
            resultsSoFar.put(target, 1);
            return 1;
        }

        if (length >= currentMax) {
            return currentMax;
        }

        Set<String> remainingStrings = new HashSet<>();

        for (int k = 0; k < length; k++) {
            if (!words[k].equals(target)) {
                remainingStrings.add(words[k]);
            }
        }

        int maxNextString = 0;

        for (int j = 0; j < length; j++) {
            String newString = target.substring(0, j) + target.substring(j + 1, length);

            // there could be multiple options. Thus it needs to figure out the max.
            if (remainingStrings.contains(newString)) {
                maxNextString = Math.max(chainLength(newString, words, resultsSoFar), maxNextString);
            }
        }

        maxNextString++;

        resultsSoFar.put(target, maxNextString);

        return maxNextString;
    }

    public static void main(String[] args) {

        String[] input = {
                "a", "and", "an", "bear"
        };

        System.out.println(TSLongestChain.longestChain(input));
    }

}
