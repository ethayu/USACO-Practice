import java.util.*;

public class Cow_Crossings {

    public static void main (String [] args) {

        Scanner sc = new Scanner (System.in);
        int[][] cows = new int[sc.nextInt()][3];
        for (int i = 0; i < cows.length; i++) {
            cows[i][0] = sc.nextInt();
            cows[i][1] = sc.nextInt();
        }
        Arrays.sort(cows, new java.util.Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int counter = cows.length;
        for (int i = 0; i < cows.length; i++) {
            for (int j = i + 1; j < cows.length; j++) {
                if (cows[i][1] > cows[j][1]) {
                    if (cows[i][2] != 1) counter--;
                    if (cows[j][2] != 1) counter--;
                    cows[j][2] = 1;
                    cows[i][2] = 1;
                }
            }
        }

        System.out.print(counter);

    }

}
