package number.ArrangingCoins;

/**
 * Created on 11/13/16.
 */
public class ArrangingCoins {

    public int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }


        int sum = 1;

        for (int step = 2; ; step++) {
            sum += step;

            if (sum > n) {
                return step - 1;
            }
        }
    }

    public int arrangeCoins_jump(int n) {
        if (n <= 0) {
            return 0;
        }

        int low = 1;
        Integer upper = null;

        return 0;

//        for (int step = Math.pow(); ; step++) {
//
//        }
    }

    public int arrangeCoins_faster(int n) {
        if (n <= 0) {
            return 0;
        }

        long num = 8 * (long) n + 1;

        double v1 = Math.sqrt(num) - 1;

        double v = v1 / 2;

        return (int) Math.floor(v);

    }

    public static void main(String[] args) {
        ArrangingCoins arrangingCoins = new ArrangingCoins();

        System.out.println(arrangingCoins.arrangeCoins_faster(1804289383));
    }
}
