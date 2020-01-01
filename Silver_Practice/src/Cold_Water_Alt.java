import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Cold_Water_Alt {

    static int[] search(int n, int[][] a) {
        int[] output = new int[4];
        Arrays.fill(output, -1);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == n) {
                    if (j == 0) {
                        output[0] = i;
                        output[1] = j;
                    } else {
                        output[2] = i;
                        output[3] = j;
                    }
                    break;
                }
                if ((output[0] != -1) && (output[1] != -1) && (output[2] != -1) && (output[3] != -1)) {
                    return output;
                }
            }
        }
        return output;
    }

    static void add(ArrayList<Integer>[] levels, int[][] a, int level) {
        if (level == 1) {
            int x = levels[0].get(0);
            int q = a[search(x, a)[0]][1];
            int r = a[search(x, a)[0]][2];
            levels[level].add(q);
            levels[level].add(r);
        } else {
            int x = levels[level-1].get(0);
            int y = levels[level-1].get(1);
            if (search(x, a)[0] != -1) {
                int q = a[search(x, a)[0]][1];
                int r = a[search(x, a)[0]][2];
                levels[level].add(q);
                levels[level].add(r);
            }
            if (search(y, a)[0] != -1) {
                int w = a[search(y, a)[0]][1];
                int s = a[search(y, a)[0]][2];
                levels[level].add(w);
                levels[level].add(s);
            }
        }
    }

    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] data = new int[m][3];
        ArrayList[] levels = new ArrayList[m+1];
        for (int i = 0; i <= m ; i++) {
            levels[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
            data[i][2] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            if (search(i, data)[2] == -1) {
                levels[0].add(i);
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            add(levels, data, i);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < levels.length; j++) {
                if (levels[j].contains(i)) {
                    System.out.println(j+1);
                    break;
                }
            }
        }


    }

}
