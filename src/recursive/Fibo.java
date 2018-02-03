package recursive;

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

    public static void main(String[] args) {
        Fibo fibo = new Fibo();

        int n = 1000;

        System.out.println(fibo.f(n));
    }
}
