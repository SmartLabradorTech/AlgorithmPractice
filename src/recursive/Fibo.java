package recursive;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by tianle on 2/3/18.
 */
public class Fibo {

    public int f(int n) {

        if (n <= 1) {
            return 1;
        }

        return f(n - 1) + f(n - 2);
    }

    public int fDP(int n) {
        if (n <= 1) {
            return 1;
        }

        int left = 1;
        int right = 1;

        int current = 0;

        for (int i = 3; i <= n; i++) {
            current = left + right;

            left = right;
            right = current;
        }

        return current;
    }

    public static void main(String[] args) {
        Fibo fibo = new Fibo();

        int n = 1000;

        Set<String> a = new HashSet<>();

        PriorityQueue<Integer> b = new PriorityQueue<>();

        System.out.println(fibo.fDP(n));
    }
}
