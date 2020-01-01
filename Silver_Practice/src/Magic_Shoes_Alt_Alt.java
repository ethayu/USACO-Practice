import java.util.*;

public class Magic_Shoes_Alt_Alt {

    static int bx, by, cx, cy, lx, ly, output = Integer.MAX_VALUE;

    static boolean found = false;

    static int[][] evens;
    static int[][] odds;

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

    static void check(int moves) {
        while (!store.isEmpty()) {
            if (moves >= output) break;
            int[] temp = store.remove();
            int x = temp[0];
            int y = temp[1];
            if ((x == cx) && (y == cy)) {
                if (moves < output) output = moves;
                break;
            }
            if (moves % 2 == 1) {
                if (evens[x-1][y-1] == 1) continue;
                else {
                    evens[x-1][y-1] = 1;
                    for (int i = 0; i < 4; i++) {
                        if (isinBounds(x + ex[i], y + ey[i])) {
                            store.add(new int[] {x + ex[i], y + ey[i]});
                            check(moves + 1);
                        }
                    }
                }
            } else {
                if (odds[x-1][y-1] == 1) continue;
                else {
                    odds[x-1][y-1] = 1;
                    for (int i = 0; i < 8; i++) {
                        if (isinBounds(x + ox[i], y + oy[i])) {
                            store.add(new int[] {x + ox[i], y + oy[i]});
                            check(moves + 1);
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

        evens = new int[lx][ly];
        odds = new int[lx][ly];

        store.add(new int[]{bx, by});
        check(0);
        System.out.println(output);

    }

}
