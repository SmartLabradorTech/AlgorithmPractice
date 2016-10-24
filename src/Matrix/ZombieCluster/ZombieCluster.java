package Matrix.ZombieCluster;

import java.util.*;

/**
 * Created by tianleh on 10/24/16.
 */
public class ZombieCluster {

    static int zombieCluster(String[] zombies) {
        if (zombies == null) {
            return 0;
        }

        int length = zombies.length;

        if (length <= 1) {
            return 1;
        }

        int[] cluster = new int[length];

        for (int i = 0; i < length; i++) {
            cluster[i] = i;
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (zombies[i].charAt(j) == '1') {
                    updateCluster(cluster, i, j);
                }
            }
        }

        Arrays.sort(cluster);

        int count = 1;

        for (int i = 1; i < length; i++) {
            if (cluster[i] != cluster[i - 1]) {
                count++;
            }
        }

        return count;
    }

    static int zombieCluster2(String[] zombies) {
        if (zombies == null) {
            return 0;
        }

        int length = zombies.length;

        if (length <= 1) {
            return 1;
        }

        Map<Integer, Integer> zomToCluster = new HashMap<>();
        Map<Integer, Set<Integer>> clusterToZom = new HashMap<>();

        for (int i = 0; i < length; i++) {
            zomToCluster.put(i, i);
            Set<Integer> mems = new HashSet<>();
            mems.add(i);
            clusterToZom.put(i, mems);

        }

        for (int i = 0; i < length; i++) {
            Integer iCluster = zomToCluster.get(i);
            Set<Integer> iClusterMems = clusterToZom.get(iCluster);

            for (int j = i + 1; j < length; j++) {
                if (zombies[i].charAt(j) == '1') {
                    // check j's current
                    Integer jCluster = zomToCluster.get(j);

                    if (jCluster == null) {
                        // add to i's cluster
                        zomToCluster.put(j, iCluster);
                        iClusterMems.add(j);

                    } else if (jCluster != iCluster) {
                        // use iCluster
                        Set<Integer> jClusterMems = clusterToZom.get(jCluster);

                        for (Integer each : jClusterMems) {
                            zomToCluster.put(each, iCluster);
                            iClusterMems.add(each);
                        }

                        // no need to keep jCluster
                        clusterToZom.remove(jCluster);
                    }

                }
            }
        }

        return clusterToZom.size();
    }

    private static void updateCluster(int[] cluster, int i, int j) {
        if (cluster[i] != cluster[j]) {
            for (int p = 0; p < cluster.length; p++) {
                if (cluster[p] == cluster[j]) {
                    cluster[p] = cluster[i];
                }
            }
        }
    }
}
