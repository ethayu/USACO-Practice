import java.util.*;

public class Chocolate_Buying_Alt {

    public static void main(String [] args) {

        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        double budget = sc.nextDouble();
        double[][] options = new double[n][3];
        for (int i = 0; i < options.length; i++) {
            options[i][1] = sc.nextInt();
            options[i][2] = sc.nextInt();
            options[i][0] = options[i][1] / options[i][2];
        }

        Arrays.sort(options, new java.util.Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return Double.compare(o1[0], o2[0]);
            }
        });

        int counter = 0;
        for (int i = 0; i < options.length; i++) {
            for (int j = 0; j < options[i][2]; j++) {
                if (budget - options[i][1] * (options[i][2] - j ) >= 0) {
                    counter += options[i][2] - j;
                    budget -= options[i][1]*(options[i][2] - j);
                    break;
                }
            }
        }

        System.out.println((int)counter);


    }

}
