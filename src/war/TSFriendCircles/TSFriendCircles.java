package war.TSFriendCircles;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tianle on 3/25/18.
 */
public class TSFriendCircles {

    static int friendCircles(String[] friends) {

        // perform input validation
        if (friends == null) {
            return 0;
        }

        int length = friends.length;

        if (length == 0) {
            return 0;
        }

        // indicate the students which have been visited.
        // It will be expanding as the dfs continues.
        Set<Integer> visited = new HashSet<>();

        // indicate the students not visited.
        // It will be shrinking as the dfs continues.
        Set<Integer> allNumbers = new HashSet<>();
        for (int i = 0; i < length; i++) {
            allNumbers.add(i);
        }

        // count of circles
        int count = 0;

        while (!allNumbers.isEmpty()) {
            // pick a seed
            Integer next = allNumbers.iterator().next();

            // perform depth first search
            dfs(friends, next, visited, allNumbers);

            // Once a dfs finishes, it means a circle has been completed.
            // update the count. And check whether we can pick another seed to start.
            count++;
        }

        return count;
    }

    // a helper function to run depth first search on the graph.
    private static void dfs(String[] friends, int start, Set<Integer> path, Set<Integer> allNumbers) {
        path.add(start);

        allNumbers.remove(start);

        for (int i = 0; i < friends[start].length(); i++) {
            if (!path.contains(i) && start != i && friends[start].charAt(i) == 'Y') {
                dfs(friends, i, path, allNumbers);
            }
        }
    }
}
