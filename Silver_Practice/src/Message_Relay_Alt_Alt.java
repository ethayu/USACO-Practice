import java.util.*;

public class Message_Relay_Alt_Alt {

    public static void main (String [] args) {

        Scanner sc = new Scanner (System.in);

        int n = sc.nextInt();
        int[] data = new int[1005];
        int[] nonloopy = new int[1005];
        for (int i = 1; i <= n; i++) {
            data[i] = sc.nextInt();
            if (data[i] == 0) nonloopy[i] = 1;
        }

        int unloopy = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (nonloopy[data[j]] == 1) nonloopy[j] = 1;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (nonloopy[i] == 1) unloopy++;
        }
        System.out.print(unloopy);
    }
}