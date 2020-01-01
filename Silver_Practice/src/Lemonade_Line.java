import java.util.*;

public class Lemonade_Line {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] cows = new int[sc.nextInt()];
        for (int i = 0; i < cows.length; i++) {
            cows[i] = sc.nextInt() * - 1;
        }

        Arrays.sort(cows);

        int counter = 0;
        int a = 0;

        for (int i = 0; i < cows.length; i++) {
            if (cows[i] * -1 < counter) {}
            else counter++;
        }

        System.out.println(counter);
    }

}
