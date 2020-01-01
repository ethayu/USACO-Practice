import java.util.*;

public class Cow_Routing {

    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int min_cost = Integer.MAX_VALUE;

        int a, b;

        boolean found_first;

        int z = sc.nextInt();

        for (int i = 0; i < z; i++) {
            found_first = false;
            a = sc.nextInt();
            b = sc.nextInt();
            for (int j = 0; j < b; j++) {
                int o = sc.nextInt();
                if (found_first) {
                    if (o == y) {
                        if (min_cost > a) min_cost = a;
                    }
                }
                if (o == x) found_first = true;
            }
        }

        if (min_cost == Integer.MAX_VALUE) min_cost = -1;

        System.out.print(min_cost);


    }

}
