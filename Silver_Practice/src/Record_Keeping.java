import java.util.*;

public class Record_Keeping {

    public static void main(String [] args) {


        Scanner sc = new Scanner(System.in);

        String[][] records = new String[sc.nextInt()][3];
        int[] count = new int[records.length];
        Arrays.fill(count, -1);

        for (int i = 0; i < records.length; i++) {
            records[i][0] = sc.next();
            records[i][1] = sc.next();
            records[i][2] = sc.next();
            Arrays.sort(records[i]);
            for (int j = 0; j < i; j++) {
                if (Arrays.equals(records[j], records[i])) count[j]--;
            }
        }

        Arrays.sort(count);
        System.out.println(count[0]*-1);



    }

}
