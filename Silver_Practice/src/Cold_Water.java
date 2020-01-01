import java.util.Arrays;
import java.util.Scanner;

public class Cold_Water {

    static int[] search(int n, int[][] a) {
        boolean onlyneedtofindhead = false;
        int[] output = new int[4];
        Arrays.fill(output, -1);
        for (int i = 0; i < a.length; i++) {
            if (onlyneedtofindhead) {
                if (a[i][0] == n) {
                    output[0] = i;
                    output[1] = 0;
                }
                break;
            }
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == n) {
                    if (j == 0) {
                        output[0] = i;
                        output[1] = j;
                    } else {
                        output[2] = i;
                        output[3] = j;
                        onlyneedtofindhead = true;
                    }
                    if (onlyneedtofindhead) return output;
                }
            }
        }
        return output;
    }

    static int run (int[][] a, int[] temp, int[] save, int[][] ssave) {
        if ((temp[2] == -1)) {
            return 1;
        } else if (save[a[temp[2]][0]] != 0){
            return save[a[temp[2]][0]] + 1;
        } else return run(a, ssave[a[temp[2]][0] - 1], save, ssave) + 1;
    }

    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] data = new int[m][3];
        int[] save = new int[n + 1];
        for (int i = 0; i < m; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
            data[i][2] = sc.nextInt();
        }
        int[][] ssave = new int[n][4];

        for (int i = 0; i < ssave.length; i++) {
            Arrays.fill(ssave[i], -1);
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (j == 0) {
                    ssave[data[i][j] - 1][0] = i;
                    ssave[data[i][j] - 1][1] = 0;
                } else {
                    ssave[data[i][j] - 1][2] = i;
                    ssave[data[i][j] - 1][3] = j;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            save[i] = run(data, ssave[i - 1], save, ssave);
            System.out.println(save[i]);
        }

    }

}
