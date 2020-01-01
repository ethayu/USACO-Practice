import java.util.*;

public class Paired_Up {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] cows = new int[sc.nextInt()][2];

        for (int i = 0; i < cows.length; i++) {
            cows[i][1] = sc.nextInt();
            cows[i][0] = sc.nextInt();
        }

        Arrays.sort(cows, new java.util.Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = -1;
        int beginning = 0;
        int end = cows.length-1;

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (beginning >= end - 1) break;
            int sum = cows[beginning][0] + cows[end][0];
            if (sum > max) max = sum;
            if (cows[beginning][1] > cows[end][1]) {
                cows[beginning][1]  -= cows[end][1];
                end--;
            } else if (cows[beginning][1] < cows[end][1]) {
                cows[end][1]  -= cows[beginning][1];
                beginning++;
            } else  {
                end--;
                beginning++;
            }
        }

        System.out.println(max);
    }

}
