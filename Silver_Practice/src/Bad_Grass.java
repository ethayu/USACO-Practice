import java.util.*;

public class Bad_Grass {

    static void clean(int x, int y, Queue<int[]> water, int[][] field) {
        while (!(water.isEmpty())) {
            x = water.peek()[0];
            y = water.peek()[1];
            field[x][y] = 0;
            water.remove();
            if ((x < field.length - 1) && (y < field[0].length - 1) && (field[x + 1][y + 1] != 0)) {
                water.add(new int[]{x + 1, y + 1});
            }
            if ((x < field.length - 1) && (field[x + 1][y] != 0)) {
                water.add(new int[]{x + 1, y});
            }
            if ((x < field.length - 1) && (y > 0) && (field[x + 1][y - 1] != 0)) {
                water.add(new int[]{x + 1, y - 1});
            }
            if ((y > 0) && (field[x][y - 1] != 0)) {
                water.add(new int[]{x, y - 1});
            }
            if ((x > 0) && (y > 0) && (field[x - 1][y - 1] != 0)) {
                water.add(new int[]{x - 1, y - 1});
            }
            if ((x > 0) && (field[x - 1][y] != 0)) {
                water.add(new int[]{x - 1, y});
            }
            if ((x > 0) && (y < field[0].length - 1) && (field[x - 1][y + 1] != 0)) {
                water.add(new int[]{x - 1, y + 1});
            }
            if ((y < field[0].length - 1) && (field[x][y + 1] != 0)) {
                water.add(new int[]{x, y + 1});
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
                    clean(i, j, water, field);
                    counter++;
                }
            }
        }

        System.out.print(counter);

    }

}
