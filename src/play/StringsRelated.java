package play;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianleh on 10/18/16.
 */
public class StringsRelated {

    public static void main(String[] args) {

        String a = "0";
        String b = "11";
        String c = "1";

        List<String> strings = Arrays.asList(a, b, c);

        String[] objects = (String[]) strings.toArray();

        print(objects);

        Arrays.sort(objects);

        print(objects);
    }

    public static void print(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }

        System.out.println();

    }
}
