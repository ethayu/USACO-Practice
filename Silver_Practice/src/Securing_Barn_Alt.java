import java.util.*;

public class Securing_Barn_Alt {

    static void generate(int a, int index, int n, char[] data, String[] output, int vowel, int consonants) {
        if (a != n) {
            for (int i = index + 1; i < data.length; i++) {
                output[a] = Character.toString(data[i]);
                if ((data[i] == 'a') || (data[i] == 'e') || (data[i] == 'i') || (data[i] == 'o') || (data[i] == 'u')) {
                    generate(a + 1, i, n, data, output,vowel + 1, consonants);
                } else generate(a+1 , i, n, data, output, vowel, consonants + 1);
            }
        } else {
            if ((vowel >= 1) && (consonants >= 2) && !(output[n-1].equals(output [n-2]))) {
                String temp = "";
                for (int i = 0; i < output.length; i++) {
                    temp += output[i];
                }
                System.out.println(temp);
                if (temp.equals("istw")) {
                    System.out.println();
                }
            }
        }
    }

    public static void main( String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] data = new char[sc.nextInt()];
        for (int i = 0; i < data.length; i++) {
            data[i] = sc.next().charAt(0);
        }

        Arrays.sort(data);
        generate(0, - 1, n, data, new String[n],0, 0);

    }
}

