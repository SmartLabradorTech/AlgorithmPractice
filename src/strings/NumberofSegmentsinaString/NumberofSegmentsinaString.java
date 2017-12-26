package strings.NumberofSegmentsinaString;

/**
 * Created by tianle on 12/25/17.
 */
public class NumberofSegmentsinaString {

    public int countSegments(String s) {

        if (s == null) {
            return 0;
        }

        boolean previousEmpty = true;

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                previousEmpty = true;
                continue;
            }

            // current is a valid char
            if (previousEmpty) {
                count++;
                previousEmpty = false;
            }

        }

        return count;
    }

    public static void main(String[] args) {
        NumberofSegmentsinaString n = new NumberofSegmentsinaString();

        String s = "1 2  344";

        System.out.println(n.countSegments(s));
    }


}
