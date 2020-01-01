import java.util.*;

public class Going_Movies {

    static int big = -1;

    static void calculate (int[] data, int[] sums, int index, int lastindex, int size, int a) {
        if(index == size){
            int total = 0;
            for (int i = 0; i < sums.length; i++) {
                total += sums[i];
            }
            if ((total <= a) && (total > big)) big = total;
        } else{
            for (int i = lastindex; i < data.length; i++) {
                sums[index] = data[i];
                calculate(data, sums, index+1, i+1, size, a);
            }
        }
    }

    public static void main (String [] args) {

        Scanner sc = new Scanner (System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] data = new int[m];

        for (int i = 0; i < m; i++) {
            data[i] = sc.nextInt();
        }

        int[] sums = new int[m];

        for (int i = 0; i < m; i++) {
            int size = i + 1;
            calculate(data, sums, 0, 0, size, n);
        }
        System.out.println(big);


    }

}
