package strings.SubstringMatch;

public class SubstringMatch {

    public boolean match(String host, String pattern) {
        for (int i = 0; i < host.length(); i++) {

            if (matchCurrent(i, host, pattern)) {
                return true;
            }
        }

        return false;
    }

    private boolean matchCurrent(int start, String host, String pattern) {

        if (host.length() - 1 - start + 1 < pattern.length()) {
            return false;
        }

        int i;

        for (i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) != host.charAt(start + i)) {
                break;
            }
        }

        return i == pattern.length();
    }

    public static void main(String[] args) {

        SubstringMatch sm = new SubstringMatch();

        String host = "abc";

        String pattern = "b";

        System.out.println(sm.match(host, pattern));
    }
}
