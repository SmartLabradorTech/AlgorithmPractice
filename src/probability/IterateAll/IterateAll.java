package probability.IterateAll;

/**
 * Created by tianle on 4/28/17.
 */
public class IterateAll {
    /*
    * suppose there are N people. You meet one at a time. However, you may meet the same person next time. So,
    * on average, how many people you need to meet to meet all people
    * */

    public double avg(int N) {
        double result = 0.0;

        int iterations = N * N;

        int[][] times = new int[iterations + 1][N + 1];

        int factor = 1;

        for (int i = 1; i <= N; i++) {
            factor *= i;
            times[i][i] = factor;
        }

        for (int i = 1; i <= iterations; i++) {
            times[i][1] = 1;
        }

        for (int p = 2; p <= N; p++) {
            for (int q = p; q <= iterations; q++) {
                times[q][p] = p * times[q - 1][p - 1];
            }
        }

        for (int i = N; i <= iterations; i++) {
            result += (1.0 * i * times[i][N] / Math.pow(N, i));
        }

        return result;
    }

    public static void main(String[] args) {
        IterateAll iterateAll = new IterateAll();

        System.out.println(iterateAll.avg(3));
    }
}
