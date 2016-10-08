package number.RomantoInteger;

import number.IntegertoRoman.IntegertoRoman;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tianleh on 10/6/16.
 * <p>
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomantoInteger {

    public int romanToInt(String s) {

        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        characterIntegerMap.put('I', 1);
        characterIntegerMap.put('V', 5);
        characterIntegerMap.put('X', 10);
        characterIntegerMap.put('L', 50);
        characterIntegerMap.put('C', 100);
        characterIntegerMap.put('D', 500);
        characterIntegerMap.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {

            int current = characterIntegerMap.get(s.charAt(i));

            if (i == s.length() - 1) {
                result += current;
            } else {
                int next = characterIntegerMap.get(s.charAt(i + 1));

                if (current >= next) {
                    result += current;
                } else {
                    result += (next - current);
                    i++;
                }

            }

        }

        return result;
    }

    public static void main(String[] args) {
        RomantoInteger romantoInteger = new RomantoInteger();

        System.out.println("result is " + romantoInteger.romanToInt("XLIII"));
    }
}
