import java.util.*;

public class Knights_Ni {

    static int bx, by, sx, sy, moves = -1, fminmoves = Integer.MAX_VALUE, lminmoves = Integer.MAX_VALUE;

    static int[] r = {0, 0, 1, -1};
    static int[] c = {1, -1, 0, 0};

    static boolean isinBounds(int x, int y, int mx, int my) {
        if ((x >= 0) && (x < mx)){
            if ((y >= 0) && (y < my)) return true;
        }
        return false;
    }

    static boolean contains(int[] a, Queue<int[]> line) {
        Queue<int[]> temp = new LinkedList<>(line);
        for (int i = 0; i < line.size(); i++) {
            if (Arrays.equals(temp.remove(), a)) return true;
        }
        return false;
    }

    static void generate(int[][] field, Queue<int[]> waiting, int situation){ //situations: 0 - looking for 4, 1 -looking for 3
        boolean[][] visited = new boolean[field.length][field[0].length];
        while (!waiting.isEmpty()) {
            moves = waiting.peek()[2] + 1;
            int x = waiting.peek()[0];
            int y = waiting.remove()[1];
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int a = x + r[i];
                int b = y + c[i];
                if (isinBounds(a, b, field.length, field[i].length)) {
                    if (visited[a][b] != true) {
                        if (field[a][b] != 1) {
                            if (situation == 0) {
                                if (field[a][b] == 4) {
                                    moves++;
                                    if (moves < fminmoves) fminmoves = moves;
                                    moves = -1;
                                    sx = a;
                                    sy = b;
                                    waiting.clear();
                                } else {
                                    if (!contains(new int[] {a, b, moves}, waiting)) waiting.add(new int[] {a, b, moves});
                                }
                            } else {
                                if (field[a][b] == 3) {
                                    moves++;
                                    if (moves < lminmoves) lminmoves = moves;
                                    moves = -1;
                                    waiting.clear();
                                } else {
                                    if (!contains(new int[] {a, b, moves}, waiting)) waiting.add(new int[] {a, b, moves});
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int z = sc.nextInt();
        int w = sc.nextInt();
        int[][] field = new int[w][z];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = sc.nextInt();
                if (field[i][j] == 2) {
                    bx = i;
                    by = j;
                }
            }
        }

        Queue<int[]> waiting = new LinkedList<>();
        waiting.add(new int[]{bx, by, -1});
        generate(field, waiting, 0);
        waiting.add(new int[]{sx, sy, -1});
        generate(field, waiting, 1);
        System.out.println(lminmoves+fminmoves);


    }

}
