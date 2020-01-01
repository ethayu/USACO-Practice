import java.util.*;
public class Super_Paintball {

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cows = new int[sc.nextInt()][2];

        for (int i = 0; i < cows.length ; i++) {
            cows[i][0] = sc.nextInt() - 1;
            cows[i][1] = sc.nextInt() - 1;
        }

        int counter = 0;
        int n_covered = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                n_covered = 0;
                int[] covered = new int[cows.length];
                for (int k = 0; k < cows.length; k++) {
                    if ((cows[k][0] == i) || (cows[k][1] == j) || ((Math.abs(cows[k][0] - i) == (Math.abs(cows[k][1] - j))))) {
                        if (covered[k] == 0) n_covered++;
                        covered[k] = 1;
                        if (n_covered == cows.length) {
                            counter++;
                            break;
                        }
                    }
                }
            }

        }
        System.out.print(counter);

    }

}
