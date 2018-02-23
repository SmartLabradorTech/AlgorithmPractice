package application;

import java.text.DecimalFormat;

/**
 * Created by tianle on 2/20/18.
 */
public class SplitUberEats {

    public void split(double[] orders, double total) {

        int length = orders.length;

        double sum = 0;

        for (int i = 0; i < length; i++) {
            sum += orders[i];
        }

        for (int i = 0; i < length; i++) {
            double fee = orders[i] / sum * total;
            fee += 0.01;

            DecimalFormat df = new DecimalFormat("#.##");

            System.out.println("For input " + orders[i] + ", fee is " + df.format(fee));
        }

    }

    public void split1(double[] orders, double total) {

        int length = orders.length;

        double sum = 0;

        for (int i = 0; i < length; i++) {
            sum += orders[i];
        }

        for (int i = 0; i < length; i++) {
            double fee = orders[i] / sum * total;
            fee += 0.01;

            DecimalFormat df = new DecimalFormat("#.##");

            System.out.println(df.format(fee));
        }

    }

    public static void main(String[] args) {
        SplitUberEats splitUberEats = new SplitUberEats();

//        double[] ints = {9.99, 11.99, 8.99, 9.99};
//        double total = 52.59;

//        double[] ints = {15.99, 9.99, 14.99};
//        double total = 52.60;

        double[] ints = {21.99, 9.99, 14.99, 13.99};
        double total = 74.61;

        splitUberEats.split(ints, total);

        System.out.println("****************");

        splitUberEats.split1(ints, total);
    }
}
