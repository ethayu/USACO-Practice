import java.util.*;

public class Islands {

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int added_same = -1;
        boolean as = false;
        int n = sc.nextInt() + 2;
        int[][] islands = new int[n][3];
        islands[0] = new int[]{0, 0, 0};
        for (int i = 1; i <islands.length-1 ; i++) {
            islands[i][0] = i;
            islands[i][1] = sc.nextInt();
            int r = i-2;
            if (i == 1) continue;
            if (as) {
                as = false;
                r = added_same;
            }
            if (islands[r][1] > islands[r+1][1]) {
                if (islands[r+1][1] > islands[i][1]) islands[r+1][2] = 0;
                else islands[r+1][2] = 1;
            }

            if (islands[r][1] < islands[r+1][1]) {
                if (islands[r+1][1] < islands[i][1]) islands[r+1][2] = 0;
                else islands[r+1][2] = -1;
            }
            if (islands[r][1] == islands[r+1][1]) {
                added_same = i-2;
                as = true;
                islands[r+1][2] = 0;
            }
            if ((i == islands.length - 2) && (islands[r+1][1] < islands[i][1])) islands[i][2] = -1;
        }
        islands[islands.length-1][1] = Integer.MAX_VALUE;

        Arrays.sort(islands, new java.util.Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int max = Integer.MIN_VALUE;
        int a = 1;
        for (int i = 0; i < islands.length - 1; i++) {
            a += islands[i][2];
            if (islands[i][0] != islands[i+1][0]) {
                if (max < a) max = a;
            }
        }
        System.out.print(max);

    }

}
