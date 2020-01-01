import java.util.*;

public class Obstacle_Course {

    static void solve(int ax, int bx, int ay, int by, char[][] field, int turns, Stack<int[]> moves) {

        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0 : {

                }
                case 1 : {

                }
                case 2 : {

                }
                case 3 : {

                }
            }
        }

    }

    public static void main (String[] args) {

        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        char[][] field = new char[n][n];

        int ax = 0, ay = 0, bx = 0, by = 0;

        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < n; j++) {
                field[i][j] = row.charAt(j);
                if (field[i][j] == 'A') {
                    ax = i;
                    ay = j;
                } else if (field[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        int turns = 0;

        Stack<int[]> moves = new Stack<>();


        solve(ax, bx, ay, by, field, turns, moves);




    }

}
