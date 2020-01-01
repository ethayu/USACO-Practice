import java.util.*;

public class Breed_Proximity {

    public static void main(String [] args) {

        Scanner sc = new Scanner (System.in);
        int[][] memes = new int[sc.nextInt()][2];
        ArrayList<Integer> arraybreeds = new ArrayList<>();
        int between_size = sc.nextInt();

        for (int i = 0; i < memes.length; i++) {
            memes[i][0] = sc.nextInt();
            memes[i][1] = i;
        }

        Arrays.sort(memes, new java.util.Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int o = -1;

        for (int i = memes.length - 1; i > -1; i--) {
            for (int j = i - 1; j > - 1 ; j--) {
                if (memes[j][0] != memes[i][0]) break;
                else {
                    if (memes[j][1] - memes[i][1] > 0) {
                        if (memes[j][1] - memes[i][1] <= between_size) {
                            o = memes[j][0];
                            break;
                        }
                    } else {
                        if (-1 * (memes[j][1] - memes[i][1]) <= between_size) {
                            o = memes[j][0];
                            break;
                        }
                    }
                }
                if (o != -1) break;
                    //if (Math.abs(memes[j][1] - memes[i][1]) <= between_size) ;
                    //System.out.println(Math.abs(memes[j][1] - memes[i][1]));
                    //System.out.println(between_size);
                    //o = memes[j][0];
                    //break;
            }
            if (o != -1) break;
        }

       /** for (int a = arraybreeds.size()-1; a > -1; a--) {
            for (int i = 0; i < memes.length; i++) {
                if (memes[i] == arraybreeds.get(a)) {
                    for (int j = i + 1; j < memes.length; j++) {
                        if (memes[j] == arraybreeds.get(a)) {
                            if (j - i <= between_size) {
                                o = arraybreeds.get(a);
                                break;
                            }
                        }
                        if (o != -1) break;
                    }
                }
                if (o != -1) break;
            }
            if (o != -1) break;
        }**/

        if (o == -1) {
            System.out.println(-1);
        } else System.out.println(o);

    }

}
