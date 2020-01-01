import java.util.*;

public class Secret_Code {
    static int counter = 0;

    static boolean isSubstring (String append, String original) {
        if ((append.length() != 0) && (original.length() - 1== append.length())) {
            if (original.substring(0, original.length()-1).equals(append)) return true;
            else if (original.substring(1, original.length()).equals(append)) return true;
        }
        return false;
    }

    static void check(String result) {
        //original at beginning
        String append = result.substring((result.length()-1)/2 + 1);
        String original = result.substring(0, (result.length()-1)/2 + 1);
        if (isSubstring(append, original)) {
            counter++;
            if (original.equals(append+append.charAt(0))) counter++;
            check(original);
        }
        //original at end
        append = result.substring(0, (result.length() - 1) / 2);
        original = result.substring((result.length() - 1) / 2);
        if (isSubstring(append, original)) {
            counter++;
            if (original.equals(append+append.charAt(0))) counter++;
            check(original);
        }
    }

    public static void main(String [] args) {
        Scanner sc = new Scanner (System.in);
        check(sc.next());
        System.out.println(counter);
    }
}
