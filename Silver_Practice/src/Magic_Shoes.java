import java.util.*;

public class Magic_Shoes {

    static int bx, by, cx, cy, lx, ly, output;

    static boolean found = false;

    static Queue<int[]> store = new LinkedList<>();

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

    static void check(int moves, int limit) {
        while (!store.isEmpty()) {
            int x = store.peek()[0];
            int y = store.peek()[1];
            store.remove();
            if (moves <= limit) {
                if ((x == cx) && (y == cy)) output = limit;
                store.clear();
            }
            if ((x != cx) || (y != cy)) {
                if (moves > limit) {
                    store.add(new int[]{moves, limit + 1, x, y});
                }
                if ((moves + 1) % 2 == 0) {
                    for (int i = 0; i < 4; i++) {
                        if (isinBounds(x + ex[i], y + ey[i])) {
                            store.add(new int[]{x + ex[i], y + ey[i]});
                            check(moves + 1, limit);
                        }
                    }
                } else {
                    for (int i = 0; i < 8; i++) {
                        if (isinBounds(x + ox[i], y + oy[i])) {
                            store.add(new int[]{x + ox[i], y + oy[i]});
                            check(moves + 1, limit);
                        }
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

        int moves = 0;
        int[][] taken = new int[lx][ly];

        store.add(new int[]{bx, by});
        while (!found) {
            check(0, moves);
        }
        System.out.println(output);

    }

}
