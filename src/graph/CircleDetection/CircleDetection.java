package graph.CircleDetection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by tianle on 9/23/17.
 * <p>
 * Check whether this is a circle inside a directed graph
 */
public class CircleDetection {

    public boolean hasCircle(int n, int[][] edges) {

        Set<Integer> candidates = new HashSet<>();

        // parse the graph

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int start = edges[i][0];
            int end = edges[i][1];

            Set<Integer> prerequests = graph.get(start);

            if (prerequests == null) {
                prerequests = new HashSet<>();
                graph.put(start, prerequests);
            }

            prerequests.add(end);
        }

        for (int start : graph.keySet()) {


        }

        return false;
    }



    private boolean canReachSelf(int start, Map<Integer, Set<Integer>> graph, Set<Integer> path) {

        return false;
    }
}
