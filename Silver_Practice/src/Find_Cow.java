import java.util.*;

public class Find_Cow {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String stuff = sc.next();

        int left = 0, right = 0, a = 0;

        for (int i = 0; i < stuff.length() - 1; i++) {
            if (stuff.substring(i, i+2).equals("((")) {
                left++;
                a -= right;
            }
            if (stuff.substring(i, i+2).equals("))")) {
                right++;
            }
        }

        System.out.print(a + left*right);
    }

}
