import java.util.*;

public class Bad_Grass_Alt {

    static int[] r = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] c = {-1, 0, 1, -1, 1, -1, 1, 0 };

    static boolean isinBounds (int x, int y, int a, int b) {
        if(0 <= x && x < a){
            if(0 <= y && y < b){
                return true;
            }
        }
        return false;
    }

    static void clean(Queue<int[]> water, int[][] field) {
        while (!(water.isEmpty())) {
            int x = water.peek()[0];
            int y = water.peek()[1];
            field[x][y] = 0;
            water.remove();
            for (int i = 0; i < 8; i++) {
                if (isinBounds(x + r[i],y + c[i], field.length, field[i].length)) {
                    if (field[x + r[i]][y + c[i]] != 0) {
                        water.add(new int[]{x + r[i], y + c[i]});
                    }
                }
            }
        }
    }

    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);

        int[][] field = new int[sc.nextInt()][sc.nextInt()];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = sc.nextInt();
            }
        }

        Queue<int[]> water = new LinkedList<>();
        int counter = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] != 0) {
                    water.add(new int[]{i, j});
                    clean(water, field);
                    counter++;
                }
            }
        }

        System.out.print(counter);

    }

}
