import java.util.*;

public class Wheres_Bessie {

    static int[] r = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] c = {-1, 0, 1, -1, 1, -1, 1, 0 };

    static boolean isinBounds (int x, int y, int lf, int uf, int lh, int uh) {
        if(lf <= x && x < uf){
            if(lh <= y && y < uh){
                return true;
            }
        }
        return false;
    }

    static void look(int m, int n, int a, int j, int k, int l, int[][] covered, char[][] image, Queue<int[]> filled){
        filled.add(new int[]{m, n});
        while (!filled.isEmpty()) {
            int x = filled.peek()[0];
            int y = filled.peek()[1];
            covered[x][y] = 1;
            for (int i = 0; i < 8; i++) {
                if (isinBounds(x + r[i],y + c[i], a, k, j, l)) {
                    if ((image[x + r[i]][y + c[i]] == image[m][n]) && (covered[x + r[i]][y + c[i]] == 0)) {
                        look(x + r[i], y + c[i], a, j, k, l, covered, image, filled);
                    }
                }
            }
        }
    }

    static boolean isPCL(int i, int j, int k, int l, char[][] image, int[][] covered) {
        for (int m = 0; m < covered.length; m++) {
            Arrays.fill(covered[m], 0);
        }
        int num_colors = 0;
        int[] colors = new int[26];
        for (int m = i; m < k; m++) {
            for (int n = j; n < l; n++) {
                if (covered[m][n] == 0) {
                    if (colors[image[m][n] - 'A'] == 0) num_colors++;
                    colors[image[m][n] - 'A']++;
                    Queue<int[]> filled = new LinkedList<>();
                    look(m, n, i, j, k, l, covered, image, filled);
                }
            }
        }
        if (num_colors != 2) return false;
        int ones = 0;
        int others = 0;
        for (int n = 0; n < 26; n++) {
            if (colors[n] != 0) {
                if (colors[n] == 1) ones++;
                if (colors[n] > 1) others++;
            }
        }
        return ((ones == 1) && (others == 1));
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] image = new char[n][n];
        int[][] covered = new int[n][n];

        for (int i = 0; i < image.length; i++) {
            String row = sc.next();
            for (int j = 0; j < image[i].length; j++) {
                image[i][j] = row.charAt(j);
            }
        }

        HashSet<int[]> plcs= new HashSet<>();


        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                for (int k = i+1; k < image.length; k++) {
                    for (int l = j+1; l < image[k].length; l++) {
                        if (isPCL(i, j, k , l, image, covered)) {
                            plcs.add(new int[]{i, j, k , l});
                        }
                    }
                }
            }
        }

        /**for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                if (i*j < 1) continue;
                HashSet<Character> colors = new HashSet<Character>();
                for (int k = 0; k <= i ; k++) {
                    for (int l = 0; l <= j; l++) {
                        if (!colors.contains(image[i][j])) {
                            colors.add(image[i][j]);
                        } else {
                            break;
                        }
                        fill.add(new int[]{k, l});
                        flood(fill, image, plcs);
                        if (plcs.size() > 0) {
                            System.out.println(123);
                        }
                     }
                }
            }
        }**/

        System.out.print(1);



    }

}
