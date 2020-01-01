import java.util.*;

public class Magic_Shoes_Alt {

    static int bx, by, cx, cy, lx, ly;

    static boolean found = false;

    static int[] ex = {0, 0, 2, -2};
    static int[] ey = {-2, 2, 0, 0};
    static int[] ox = {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] oy = {2, -2, 1, -1, 2, -2, 1, -1};

    static boolean isinBounds(int x, int y) {
        if (!(x < 1) && !(x > lx)) {
            if (!(y < 1) && !(y > ly)) {
                return true;
            }
        }
        return false;
    }

    static int limit = 1;

    static void check(int moves, int x, int y) {
        if ((x == cx) && (y == cy)) found = true;
        if (found) {
            System.out.println(limit);
            System.exit(0);
        }
        if (moves <= limit) {
            if ((x == cx) && (y == cy)) found = true;
            if (found) {
                System.out.println(limit);
                System.exit(0);
            }
            if ((x != cx) || (y != cy)) {
                if (moves % 2 == 0) {
                    int i;
                    for (i = 0; i < 4; i++) {
                        if (isinBounds(x + ex[i], y + ey[i])) {
                            check(moves + 1, x + ex[i], y + ey[i]);
                        }
                    }
                    if ((limit == moves) && (i == 4)) {
                        limit++;
                        check(moves, x, y);
                    }
                } else {
                    int i;
                    for (i = 0; i < 8; i++) {
                        if (isinBounds(x + ox[i], y + oy[i])) {
                            check(moves + 1, x + ox[i], y + oy[i]);
                        }
                    }
                    if ((limit == moves) && (i == 8)) {
                        limit++;
                        check(moves, x, y);
                    }
                }
            }
        }
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        lx = sc.nextInt();
        ly = sc.nextInt();
        bx = sc.nextInt();
        by = sc.nextInt();
        cx = sc.nextInt();
        cy = sc.nextInt();

        check(1, bx, by);
        System.out.println(limit);

    }

}
