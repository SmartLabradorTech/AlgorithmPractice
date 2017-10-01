package greedy.CourseScheduleIII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by tianle on 9/30/17.
 * <p>
 * https://leetcode.com/problems/course-schedule-iii/discuss/
 */
public class CourseScheduleIII {

    private class Course {
        int t;
        int d;
    }

    private List<Course> parse(int[][] courses) {
        List<Course> result = new ArrayList<>();

        for (int i = 0; i < courses.length; i++) {
            Course course = new Course();
            course.t = courses[i][0];
            course.d = courses[i][1];

            if (course.t > course.d) {
                // this course cannot be taken anywhere
                continue;
            }

            result.add(course);
        }

        return result;
    }

    public int scheduleCourse(int[][] courses) {

        List<Course> parse = parse(courses);

        if (parse.isEmpty()) {
            return 0;
        }

        Collections.sort(parse, (o1, o2) -> {
            if (o1.d < o2.d) {
                return -1;
            } else if (o1.d > o2.d) {
                return 1;
            }

            return 0;
        });

        PriorityQueue<Course> sofar = new PriorityQueue<>((Comparator) (o1, o2) -> {
            int time1 = ((Course) o1).t;
            int time2 = ((Course) o2).t;
            if (time1 < time2) {
                return 1;
            } else if (time1 > time2) {
                return -1;
            }

            return 0;
        });

        int duration = 0;

        for (int i = 0; i < parse.size(); i++) {

            // try to take current course i
            Course course = parse.get(i);

            if (duration + course.t <= course.d) {
                // within limit
                sofar.add(course);
                duration += course.t;

                continue;
            }

            Course peek = sofar.peek();

            if (peek.t <= course.t) {
                continue;
            }

            sofar.poll();
            duration -= peek.t;

            sofar.add(course);
            duration += course.t;
        }

        return sofar.size();
    }

    public int[][] create() {
        return new int[][]{
                {5, 5},
                {4, 6},
                {2, 6}
        };
    }

    //    [[7,17],[3,12],[10,20],[9,10],[5,20],[10,19],[4,18]]
    public int[][] create2() {
        return new int[][]{
                {7, 17},
                {3, 12},
                {10, 20},
                {9, 10},
                {5, 20},
                {10, 19},
                {4, 18}
        };
    }

    public static void main(String[] args) {

        CourseScheduleIII cs = new CourseScheduleIII();

        System.out.println(cs.scheduleCourse(cs.create2()));
    }
}
