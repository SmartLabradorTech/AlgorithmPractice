package play;

/**
 * Created by tianleh on 10/24/16.
 */
public class TestException {


    public static void main(String[] args) {

        try {
            double a = 1 / 0;


        } catch (Exception e) {

            System.out.println(e.getCause() + e.getMessage());

        }

        System.out.println("HERE IS IT");


    }
}
