package strings.SwapOddAndEven;

/**
 * Created on 11/13/16.
 */
public class SwapOddAndEven {

    public String swap(String input) {
        int length = input.length();

        if (length <= 1) {
            return input;
        }

        String firstTwoSwapped = input.charAt(1) + "" + input.charAt(0);

        if (length == 2) {
            return firstTwoSwapped;
        }


        return firstTwoSwapped + swap(input.substring(2));
    }

    public static void main(String[] args) {

        SwapOddAndEven swapOddAndEven = new SwapOddAndEven();

        System.out.println(swapOddAndEven.swap("1234"));

        System.out.println(swapOddAndEven.swap("123"));

        System.out.println(swapOddAndEven.swap("1"));
    }

}
