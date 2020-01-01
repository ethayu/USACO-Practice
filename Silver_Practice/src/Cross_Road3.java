import java.util.*;

public class Cross_Road3 {

    static int abc = 0;

    static int[] r = {0, 0, -1, 1};
    static int[] c = {1, -1, 0, 0};

    static boolean isinBounds(int x, int y, int size) {
        if (!(x < 0) && !(x >= size)) {
            if (!(y < 0) && !(y >= size)) return true;
        }
        return false;
    }

    static void traverse (Queue<int[]> line, int[][][] field) {
        while(!line.isEmpty()) {
            int x = line.peek()[0];
            int y = line.remove()[1];
            field[x][y][0] = 1;
            if (field[x][y][5] == 1) {
                field[x][y][5]++;
                abc++;
            }
            for (int i = 0; i < 4; i++) {
                if (isinBounds(x + r[i], y + c[i], field.length)) {
                    if ((field[x][y][i+1] != 1) && (field[x+r[i]][y+c[i]][0] != 1)){
                        line.add(new int[]{x + r[i], y + c[i]});
                    }
                }
            }

        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int nofcows = sc.nextInt();
        int nofroad = sc.nextInt();

        int[][][] field = new int[size][size][6];

        for (int i = 0; i < nofroad; i++) {
            int[] temp = new int[4];
            for (int j = 0; j < 4; j++) {
                temp[j] = sc.nextInt() - 1;
            }
            int dx = temp[2] - temp[0];
            int dy = temp[3] - temp[1];
            if (dx == 0) {
                if (dy == 1) {
                    field[temp[0]][temp[1]][1] = 1;
                    field[temp[2]][temp[3]][2] = 1;
                } else {
                    field[temp[0]][temp[1]][2] = 1;
                    field[temp[2]][temp[3]][1] = 1;
                }
            } else {
                if (dx == 1) { //dy = 0
                    field[temp[0]][temp[1]][4] = 1;
                    field[temp[2]][temp[3]][3] = 1;
                } else {
                    field[temp[0]][temp[1]][3] = 1;
                    field[temp[2]][temp[3]][4] = 1;
                }
            }
        }
        for (int i = 0; i < nofcows; i++) {
            field[sc.nextInt()-1][sc.nextInt() - 1][5] = 1;
        }

        Queue<int[]> line = new LinkedList<>();

        int sum = (nofcows * (nofcows - 1))/2;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j][0] == 1) continue;
                line.add(new int[] {i, j});
                traverse(line, field);
                sum -= (abc * (abc - 1))/2;
                abc = 0;
            }
        }
        System.out.println(sum);
    }

}
