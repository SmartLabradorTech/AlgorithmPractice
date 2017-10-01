package greedy.CourseScheduleIII;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by tianle on 10/1/17.
 */
public class CourseScheduleIIIClean {

    public int scheduleCourse(int[][] courses) {

        if (courses == null || courses.length == 0) {
            return 0;
        }

        // sort by deadline
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        int total = 0;

        PriorityQueue<Integer> selected = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < courses.length; i++) {
            int time = courses[i][0];
            int deadline = courses[i][1];

            if (time + total <= deadline) {
                // take it
                selected.add(time);
                total += time;
            } else {

                // let's check the top one
                if (selected.isEmpty()) {
                    continue;
                }

                int topTime = selected.peek();

                if (time >= topTime) {
                    continue;
                }

                selected.poll();
                total -= topTime;

                selected.add(time);
                total += time;
            }
        }

        return selected.size();
    }
}
