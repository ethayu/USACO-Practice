import java.util.*;

public class Message_Relay_Alt {

    static int trace(int index, int[] data, int n) {
        for (int i = 0; i < data.length; i++) {
            if (i == index) continue;
            if (data[i] == index + 1) {
                n += 1 + trace(i, data, n+1);
            }
        }
        return n;
    }

    public static void main (String [] args) {

        Scanner sc = new Scanner (System.in);

        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        int unloopy = 0;
        for (int i = 0; i < n; i++) {

            if (data[i] == 0) {
                unloopy += trace(i, data, 0);
            };

        }
        System.out.print(unloopy);
    }

}
