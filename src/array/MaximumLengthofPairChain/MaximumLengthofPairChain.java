package array.MaximumLengthofPairChain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianle on 3/24/18.
 * https://leetcode.com/problems/maximum-length-of-pair-chain/description/#
 */
public class MaximumLengthofPairChain {

    // doesn't work!!!
    public int findLongestChain(int[][] pairs) {
        List<List<Integer>> intervals = new ArrayList<>();

        int length = pairs.length;

        for (int i = 0; i < length; i++) {
            // for each interval
            if (intervals.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                intervals.add(list);
                continue;
            }

            int left = pairs[i][0];
            int right = pairs[i][1];

            boolean hasInserted = false;

            for (List<Integer> list : intervals) {
                // try to insert into each list

                if (right < pairs[list.get(0)][0]) {
                    list.add(0, i);
                    hasInserted = true;
                } else if (left > pairs[list.get(list.size() - 1)][1]) {
                    list.add(list.size(), i);
                    hasInserted = true;
                } else {

                    for (int j = 0; j < list.size(); j++) {
                        if (left > pairs[j][1]) {

                        }
                    }

                }
            }

        }

        return 0;
    }
}
