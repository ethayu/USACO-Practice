import java.util.*;

public class Spiral_Walk {

    public static void main (String [] args) {

        Scanner sc = new Scanner (System.in);

        int n = sc.nextInt();

        int[][] output = new int[n][n];

        int i = 0;
        int x = -1;
        int y = 0;
        int dir = 0; // 0 right 1 down 2 left 3 up
        int a = n/2;
        int b = n/2;
        if ((n % 2) == 0) a = n/2 - 1;
        while ((x != a) || (y != b)) {
            i++;
            if (dir == 0) {
                if ((x == n - 1) || (output[x + 1][y] != 0)) {
                    dir = 1;
                } else x++;
            }
            if (dir == 1) {
                if ((y == n - 1) || (output[x][y + 1] != 0)) {
                    dir = 2;
                } else y++;
            }
            if (dir == 2) {
                if ((x == 0) || (output[x - 1][y] != 0)) {
                    dir = 3;
                } else x--;
            }
            if (dir == 3) {
                if ((y == 0) || (output[x][y - 1] != 0)) {
                    dir = 0;
                    i--;
                    continue;
                } else y--;
            }
            output[x][y] = i;
        }

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                System.out.print(output[k][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }

}
