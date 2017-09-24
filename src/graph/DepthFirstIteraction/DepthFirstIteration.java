package graph.DepthFirstIteraction;

import java.util.*;

/**
 * Created by tianle on 9/23/17.
 */
public class DepthFirstIteration {

    public boolean print(Map<Integer, Set<Integer>> graph) {
        for (int start : graph.keySet()) {
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

    public static void main(String[] args) {
        DepthFirstIteration d = new DepthFirstIteration();

        System.out.println(d.print(d.convert(d.create())));
    }
}
