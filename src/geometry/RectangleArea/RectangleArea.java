package geometry.RectangleArea;

/**
 * Created by tianle on 10/1/17.
 * <p>
 * https://leetcode.com/problems/rectangle-area/description/
 */
public class RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        return area(A, B, C, D) + area(E, F, G, H) - intervalOverlap(A, C, E, G) * intervalOverlap(B, D, F, H);
    }

    private int intervalOverlap(int a, int b, int c, int d) {
        if (a > c) {
            return intervalOverlap(c, d, a, b);
        }

        if (c >= b) {
            return 0;
        }

        if (d > b) {
            return b - c;
        }

        return d - c;
    }

    private int area(int a, int b, int c, int d) {
        return (a - c) * (b - d);
    }
}
