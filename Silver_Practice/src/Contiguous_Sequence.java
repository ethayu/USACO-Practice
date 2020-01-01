import java.util.*;
public class Contiguous_Sequence {

    static boolean check (int[] temp, int[] b) {
        for (int i = 0; i < b.length - temp.length; i++) {
            int[] a = Arrays.copyOfRange(b, i, i + temp.length);
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] != a[j]) break;
                if (j == temp.length - 1) return true;
            }
        }
        return false;
    }

    public static void main( String [] args) {

        Scanner sc = new Scanner ( System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] a = new int[x];
        int[] b = new int[y];

        for (int i = 0; i < x; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < y; i++) {
            b[i] = sc.nextInt();
        }
        int sizeoftemp = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if ((j - i) < sizeoftemp) break;
                int[] temp = Arrays.copyOfRange(a, i, j);
                if (check(temp, b)) {
                    sizeoftemp = temp.length;
                    break;
                };
            }
        }
        System.out.println(sizeoftemp);

    }

}