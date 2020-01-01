import java.util.*;

public class Cow_Art_Alt {

    static int cowregions = 0;
    static int humanregions = 0;

    static boolean isinBounds(int limit, int x, int y) {
        if ((x >= 0) && (x < limit)) {
            if ((y >= 0) && (y < limit)) {
                return true;
            }
        }
        return false;
    }

    static void humancheck(Queue<int[]> matches, char[][] painting) {
        while (!matches.isEmpty()) {
            int x = matches.peek()[0];
            int y = matches.peek()[1];
            char compare = painting[x][y];
            painting[x][y] = '.';
            matches.remove();
            for (int i = 0; i < 8; i++) {
                if (isinBounds(painting.length, x + r[i], y + c[i])) {
                    if (painting[x+r[i]][ y+c[i]] == compare) {
                        matches.add(new int[]{x + r[i], y + c[i]});
                        humancheck(matches, painting);
                    }
                }
            }
        }
    }

    static void cowcheck(Queue<int[]> matches, char[][] painting) {
        while (!matches.isEmpty()) {
            int x = matches.peek()[0];
            int y = matches.peek()[1];
            char compare = painting[x][y];
            painting[x][y] = '.';
            matches.remove();
            for (int i = 0; i < 8; i++) {
                if ((compare == 'G') || (compare == 'R'))  {
                    if (isinBounds(painting.length, x + r[i], y + c[i])) {
                        if ((painting[x+r[i]][ y+c[i]] == 'G') || (painting[x+r[i]][ y+c[i]] == 'R')) {
                            matches.add(new int[] {x + r[i], y +c[i]});
                            cowcheck(matches, painting);
                        }
                    }
                } else {
                    if (isinBounds(painting.length, x + r[i], y + c[i])) {
                        if (painting[x + r[i]][y + c[i]] == compare) {
                            matches.add(new int[]{x + r[i], y + c[i]});
                            cowcheck(matches, painting);
                        }
                    }
                }
            }
        }
    }
    static int[] r = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] c = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<int[]> matches = new LinkedList<>();

        char[][] painting = new char[n][n];
        char[][] painting2 = new char[n][n];

        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            for (int j = 0; j < n; j++) {
                painting[i][j] = temp.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (painting[i][j] != '.') {
                    matches.add(new int[]{i, j});
                    humancheck(matches, painting);
                    humanregions++;
                    cowcheck(matches, painting2);
                    cowregions++;
                }
            }
        }
        System.out.println(humanregions + " " + cowregions);

    }

}
