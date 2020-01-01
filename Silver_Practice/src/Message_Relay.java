import java.util.*;

public class Message_Relay {

    static boolean trace(int index, int[] data, int n) {
        if (n+1 > data.length) return true;
        if (data[data[index] - 1] == index + 1) return true;
        else if (data[data[index] - 1] == 0) return false;
        else if (trace (data[index] - 1, data, n+1)) return true;
        return true;
    }

    public static void main (String [] args) {

        Scanner sc = new Scanner (System.in);

        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        int loopy = 0;
        for (int i = 0; i < n; i++) {

            if (data[i] == 0) continue;
            if (trace(i, data, 0)) loopy++;

        }
        System.out.print(n-loopy);
    }

}
