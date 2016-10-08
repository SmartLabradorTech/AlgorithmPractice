package number.IntegertoRoman;

/**
 * Created by tianleh on 10/2/16.
 * <p>
 * https://leetcode.com/problems/integer-to-roman/
 */
public class IntegertoRoman {

    public String intToRoman(int num) {

        int[] keys = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] literals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String result = "";

        for (int i = 0; i < keys.length; i++) {
            if (num >= keys[i]) {
                result += literals[i];
                num -= keys[i];
                i--;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        IntegertoRoman integertoRoman = new IntegertoRoman();

        System.out.println("The result is " + integertoRoman.intToRoman(3200));

    }
}
