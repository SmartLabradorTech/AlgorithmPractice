package graph.CourseScheduleII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by tianle on 9/28/17.
 * https://leetcode.com/problems/course-schedule-ii/description/
 */
public class CourseScheduleII {
    private Set<Integer> visited = new HashSet<>();
    private Queue<Integer> scheduled = new LinkedList<>();

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

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (prerequisites.length == 0) {
            return IntStream.range(0, numCourses).toArray();
        }

        boolean detect = detect(convert(prerequisites));

        if (detect) {
            // note that an empty array is different from an array with default values 0
            return new int[0];
        }

        int[] order = new int[numCourses];

        int index = 0;
        // note that vertex in scheduled might be less than total
        while (!scheduled.isEmpty()) {
            order[index] = scheduled.poll();
            index++;
        }

        if (index != numCourses) {
            for (int c = 0; c < numCourses; c++) {
                if (!visited.contains(c)) {
                    order[index] = c;
                    index++;
                }
            }
        }

        return order;
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
        CourseScheduleII cs = new CourseScheduleII();

        int[][] ints = cs.create4();

        System.out.println(Arrays.toString(cs.findOrder(2, ints)));
    }
}
