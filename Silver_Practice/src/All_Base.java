import java.util.*;

public class All_Base {

    public static void main( String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int valuex = -1;
            int valuey = -2;
            int k = 10;
            int j = 10;
            int x = sc.nextInt();
            int y = sc.nextInt();
            while (valuex != valuey) {
                valuex = j * j * ((((x - (x % 10)) / 10) - (((x - (x % 10)) / 10) % 10)) / 10) + j * (((x - (x % 10)) / 10) % 10) + (x % 10);
                valuey = k * k * ((((y - (y % 10)) / 10) - (((y - (y % 10)) / 10) % 10)) / 10) + k * (((y - (y % 10)) / 10) % 10) + (y % 10);
                if (valuex == valuey) break;
                if (valuex > valuey) k++;
                else j++;
            }
            System.out.println(j + " " + k);
        }
    }

}
