package graph.CourseSchedule;

import java.util.*;

/**
 * Created by tianle on 8/27/17.
 * <p>
 * https://leetcode.com/problems/course-schedule/description/
 */

public class CourseSchedule {

    private List<Integer> visited = new ArrayList<>();
    private Set<Integer> scheduled = new HashSet<>();

    private boolean detect(Map<Integer, Set<Integer>> graph) {
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

    private Map<Integer, Set<Integer>> convert(int[][] edges) {

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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }

        return !detect(convert(prerequisites));
    }
}