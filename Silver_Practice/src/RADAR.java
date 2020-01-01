import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class RADAR {

    static boolean check(int[] n) {
        for (int i = 0; i < n.length; i++) {
            if (n[i] != n[n.length-i - 1]) break;
            if (i == n.length - 1) return true;
        }
        return false;
    }

    static int add(int[] n) {
        int[] o = new int[n.length];
        for (int i = 0; i < n.length; i++) {
            o[o.length-i - 1] = n[i];
        }
        return combine(o) + combine(n);
    }

    static int combine(int[] n) {
        int a = 0;
        for (int i = 0; i < n.length; i++) {
            a += (int)(n[i] * Math.pow(10, i));
        }
        return a;
    }

    static int[] separate(int n) {
        int a = 1;
        for (a = 1; a < Integer.MAX_VALUE; a++) {
            if ((int)(n / Math.pow(10, a)) <= 0) break;
        }
        int[] out = new int[a];
        for (int i = 0; i < a; i++) {
            out[i] = n % 10;
            n = (n - (n % 10)) / 10;
        }
        return out;
    }

    public static void main( String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 0;
        while (!check(separate(n))) {
            n = add(separate(n));
            i++;
        }
        System.out.println(i + " " + n);

    }

}
