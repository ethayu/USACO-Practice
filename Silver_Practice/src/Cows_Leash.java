import java.util.*;

public class Cows_Leash {

    public static void main (String[] args) {

        Scanner sc = new Scanner (System.in);

        int[][] leashes = new int[sc.nextInt()][4];
        int[] bool = new int[leashes.length];
        for (int i = 0; i < leashes.length; i++) {
            leashes[i][3] = 0;
            leashes[i][1] = sc.nextInt();
            leashes[i][2] = sc.nextInt();
            leashes[i][0] = leashes[i][2] + leashes[i][1];
        }

        Arrays.sort(leashes, new java.util.Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        leashes[0][3] = 1;

        int counter = 0;
        int a = 0;

        boolean go = true;

        while (go) {
            int i;
            for (i = a; i < leashes.length; i++) {
                if ((a != i) && (leashes[i][3] == 0) && (leashes[i][0] >= leashes[a][0]) && (leashes[i][1] < leashes[a][0])) {
                    leashes[i][3] = 1;
                    leashes[i][0] = Integer.MAX_VALUE;
                    leashes[i][1] = Integer.MIN_VALUE;
                }
            }
            for (int j = 0; j < leashes.length; j++) {
                if (leashes[j][3] == 0) {
                    a = j;
                    j = leashes.length;
                    leashes[a][3] = 1;
                } else if (j == leashes.length - 1) go = false;
            }
            counter++;
        }
        System.out.println(counter);


    }

}
