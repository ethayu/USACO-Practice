import java.util.*;

public class Securing_Barn {

    static void generate (ArrayList<Character> bank, int n, HashSet<Character> vowels, int vowel, int consonant, String output) {
        if ((output.length() == n) && (vowel >= 1) && (consonant >= 2)){
            System.out.println(output);
        } else if (vowel >= 1) {
            for (int i = 0; i < bank.size(); i++) {
                if (vowels.contains(bank.get(i))) {
                    bank.remove(i);
                    continue;
                } else {
                    output += bank.remove(i);
                    consonant++;
                    generate(bank, n, vowels, vowel, consonant, output);
                }
            }
        } else if (consonant >= 2) {
            for (int i = 0; i < bank.size(); i++) {
                if (!(vowels.contains(bank.get(i)))) {
                    bank.remove(i);
                    continue;
                } else {
                    output += bank.remove(i);
                    vowel++;
                    generate(bank, n, vowels, vowel, consonant, output);
                }
            }
        } else {
            for (int i = 0; i < bank.size(); i++) {
                output += bank.get(i);
                if (vowels.contains(bank.remove(i))) {
                    vowel++;
                } else consonant++;
                generate(bank, n, vowels, vowel, consonant, output);
            }
        }
    }

    public static void main( String[] args) {
        Scanner sc = new Scanner (System.in);
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int n = sc.nextInt();
        char[] data = new char[sc.nextInt()];
        for (int i = 0; i < data.length; i++) {
            data[i] = sc.next().charAt(0);
        }

        Arrays.sort(data);

        ArrayList<Character> bank= new ArrayList<Character>();
        for (int i = 0; i < data.length; i++) {
            bank.add(data[i]);
        }

        for (int i = 0; i < data.length - n; i++) {
            ArrayList<Character> temp = new ArrayList<>();
            for (int j = i; j < data.length; j++) {
                temp.add(bank.get(j));
            }
            generate(temp, n, vowels, 0, 0, "");
        }
    }

}

