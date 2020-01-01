import java.util.*;

public class Lake_Counting {

    static void clean(int x, int y, Queue<int[]> water, char[][] field) {
        while (!(water.isEmpty())) {
            x = water.peek()[0];
            y = water.peek()[1];
            field[x][y] = '.';
            water.remove();
            if ((x < field.length - 1) && (y < field[0].length - 1) && (field[x + 1][y + 1] == 'W')) {
                water.add(new int[]{x + 1, y + 1});
            }
            if ((x < field.length - 1) && (field[x + 1][y] == 'W')) {
                water.add(new int[]{x + 1, y});
            }
            if ((x < field.length - 1) && (y > 0) && (field[x + 1][y - 1] == 'W')) {
                water.add(new int[]{x + 1, y - 1});
            }
            if ((y > 0) && (field[x][y - 1] == 'W')) {
                water.add(new int[]{x, y - 1});
            }
            if ((x > 0) && (y > 0) && (field[x - 1][y - 1] == 'W')) {
                water.add(new int[]{x - 1, y - 1});
            }
            if ((x > 0) && (field[x - 1][y] == 'W')) {
                water.add(new int[]{x - 1, y});
            }
            if ((x > 0) && (y < field[0].length - 1) && (field[x - 1][y + 1] == 'W')) {
                water.add(new int[]{x - 1, y + 1});
            }
            if ((y < field[0].length - 1) && (field[x][y + 1] == 'W')) {
                water.add(new int[]{x, y + 1});
            }
        }
    }

    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);

        char[][] field = new char[sc.nextInt()][sc.nextInt()];
        for (int i = 0; i < field.length; i++) {
            String row = sc.next();
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = row.charAt(j);
            }
        }

        Queue<int[]> water = new LinkedList<>();
        int counter = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'W') {
                    water.add(new int[]{i, j});
                    clean(i, j, water, field);
                    counter++;
                }
            }
        }

        System.out.print(counter);

    }

}
