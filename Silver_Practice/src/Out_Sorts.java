import java.util.*;

public class Out_Sorts {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] data = new int[sc.nextInt()][2];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = i;
        }

        Arrays.sort(data, new java.util.Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < data.length; i++) {
            if (i < data[i][1]) {
                if (data[i][1] - i > max) max = data[i][1] - i;
            }
        }

        if (max == Integer.MIN_VALUE) System.out.println(1);
        else System.out.println(max+1);

    }

}
