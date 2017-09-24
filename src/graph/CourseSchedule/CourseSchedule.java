package graph.CourseSchedule;

import java.util.*;

/**
 * Created by tianle on 8/27/17.
 * <p>
 * https://leetcode.com/problems/course-schedule/description/
 */

public class CourseSchedule {

    private class ParseResult {
        Map<Integer, Set<Integer>> graph;
        Set<Integer> canStart;
    }

    private ParseResult convert(int[][] edges) {

        int n = edges.length;

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        Set<Integer> canStart = new HashSet<>();

        Set<Integer> cannotStart = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int start = edges[i][0];
            int end = edges[i][1];

            Set<Integer> prerequests = graph.get(start);

            if (prerequests == null) {
                prerequests = new HashSet<>();
                graph.put(start, prerequests);
            }

            prerequests.add(end);

            cannotStart.add(end);
            canStart.remove(end);

            if (cannotStart.contains(start)) {
                canStart.remove(start);
            } else {
                canStart.add(start);
            }

        }

        ParseResult parseResult = new ParseResult();
        parseResult.graph = graph;
        parseResult.canStart = canStart;

        return parseResult;
    }

    private boolean print(Map<Integer, Set<Integer>> graph, Set<Integer> canStart) {
        for (int start : canStart) {
            boolean print = print(start, graph, new ArrayList<>());

            if (print) {
                return true;
            }
        }

        return false;
    }

    private boolean inside(List<Integer> path, int element) {
        return path.contains(element);
    }

    private boolean print(int current, Map<Integer, Set<Integer>> graph, List<Integer> path) {
        if (inside(path, current)) {
            return true;
        }

        path.add(current);

        Set<Integer> nexts = graph.get(current);

        if (nexts == null) {
            System.out.println(path);
            return false;
        }

        for (int node : nexts) {
            boolean print = print(node, graph, path);

            if (print) {
                return true;
            }

            path.remove(path.size() - 1);
        }

        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }

        ParseResult convert = convert(prerequisites);

        if (convert.canStart.isEmpty()) {
            return false;
        }

        return !print(convert.graph, convert.canStart);
    }

    public int[][] create2() {
        return new int[][]{
                {1, 0},
                {0, 2},
                {3, 1},
                {2, 3}
        };
    }

    public static void main(String[] args) {
        CourseSchedule d = new CourseSchedule();

//        System.out.println(d.print(d.convert(d.create2())));
    }

}
