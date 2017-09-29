package graph.CircleDetection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by tianle on 9/23/17.
 * <p>
 * Check whether this is a circle inside a directed graph
 */
public class CircleDetection {

    private List<Integer> visited = new ArrayList<>();
    private Set<Integer> scheduled = new HashSet<>();

    public boolean detect(Map<Integer, Set<Integer>> graph) {
        for (int vertex : graph.keySet()) {
            boolean start = start(vertex, graph);

            if (start) {
                return true;
            }
        }

        return false;
    }

    private boolean start(int vertex, Map<Integer, Set<Integer>> graph) {
        if (visited.contains(vertex)) {

            if (scheduled.contains(vertex)) {
                return false;
            }

            // circle found
            return true;
        }

        visited.add(vertex);

        Set<Integer> children = graph.get(vertex);

        if (children == null || children.isEmpty()) {
            // reach a leaf
            scheduled.add(vertex);
            // finish this path, no circle found for this route
            return false;
        }

        for (int child : children) {
            boolean start = start(child, graph);

            if (start) {
                return true;
            }
        }

        // all children have been added
        scheduled.add(vertex);

        return false;
    }

    public Map<Integer, Set<Integer>> convert(int[][] edges) {

        int n = edges.length;

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

        return graph;
    }

    public int[][] create() {
        return new int[][]{
                {1, 0},
                {0, 2},
                {3, 1}
        };
    }

    public int[][] create2() {
        return new int[][]{
                {1, 0},
                {0, 2},
                {3, 1},
                {2, 3}
        };
    }

    public int[][] create3() {
        return new int[][]{
                {1, 0},
                {0, 2},
                {3, 1},
                {2, 3},
                {4, 5},
        };
    }

    public int[][] create4() {
        return new int[][]{
                {1, 0}
        };
    }

    public static void main(String[] args) {
        CircleDetection circleDetection = new CircleDetection();

        System.out.println(circleDetection.detect(circleDetection.convert(circleDetection.create4())));
    }
}
