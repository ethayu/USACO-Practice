import java.util.*;

public class Guarding_Farm {

    static int counter = 0;

    static int[] r = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] c = {-1, -1, 0, 1, 1, 1, -1, 0, }

    static void look (Queue<int[]> region, int[][][] field) {
        while (!region.isEmpty()) {

        }
    }

    static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        int[][][] field = new int[sc.nextInt()][sc.nextInt()][2];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j][0] = sc.nextInt();
            }
        }

        Queue<int[]> region = new LinkedList<>();

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j][0] == 0) {
                     region.add(new int[] {i, j});
                     look(region, field);
                }
            }
        }




    }

}
