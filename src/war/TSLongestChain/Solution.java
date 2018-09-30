package war.TSLongestChain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by tianle on 3/26/18.
 */
public class Solution {

    int longestChain(String[] w) {
        int totalNumberOfWords = w.length;

        if (totalNumberOfWords == 0) {
            return 0;
        }

        Map<Integer, Set<String>> allWordsOfSameLength = new HashMap();

        int maxLen = 0;

        int maxCLen = 0;

        // find the longest length of strings in w
        for (int i = 0; i < w.length; i++) {
            int currentLength = w[i].length();

            maxLen = Math.max(maxLen, currentLength);

            if (allWordsOfSameLength.containsKey(currentLength)) {
                allWordsOfSameLength.get(currentLength).add(w[i]);
            } else {
                Set<String> strings = new HashSet();
                strings.add(w[i]);
                allWordsOfSameLength.put(currentLength, strings);
            }
        }

        // search from certain length of words
        for (int i = maxLen; i > maxCLen; i--) {
            Queue<String> stringsOfLength = new LinkedList(allWordsOfSameLength.get(i));
            // start from initial set of words to search for chain
            int clen = 0;
            while (!stringsOfLength.isEmpty()) {
                clen++;
                Set<String> nextSet = allWordsOfSameLength.get(i - clen);
                if (nextSet == null) break;
                int count = stringsOfLength.size();
                for (int h = 0; h < count; h++) {
                    String t = stringsOfLength.poll();
                    // get next string by deleting one letter
                    for (int l = 0; l < t.length(); l++) {
                        String tt = t.substring(0, l) + t.substring(l + 1);
                        if (nextSet.contains(tt)) {
                            stringsOfLength.offer(tt);
                            nextSet.remove(tt);
                        }
                    }
                }
            }
            maxCLen = Math.max(maxCLen, clen);
            i -= Math.max(clen - 1, 0);
        }
        return maxCLen;
    }

    public static void main(String[] args) {

        Solution s = new Solution();


        String[] input = {
                "a", "and", "an", "bear"
        };

        System.out.println(s.longestChain(input));
    }

}
