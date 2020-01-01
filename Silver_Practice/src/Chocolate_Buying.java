import java.util.*;

public class Chocolate_Buying {

    static int budget = 0;
    static int counter = 0;


    static void generate (int[][] options, int a) {
        for (int i = a; i < Integer.MAX_VALUE; i++) {
            for (int j = 0; j < Integer.MAX_VALUE; j++) {
                if (budget - (j * options[i][0]) >= 0) {
                    //generate
                } else break;
            }
        }
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        budget = sc.nextInt();
        int[][] options = new int[n][2];
        for (int i = 0; i < options.length; i++) {
            options[i][0] = sc.nextInt();
            options[i][1] = sc.nextInt();
        }

        int max = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            generate(options, 0);
            //if ()
        }

        System.out.println(max);


    }

}
