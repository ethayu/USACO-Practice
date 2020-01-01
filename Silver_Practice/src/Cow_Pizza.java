import java.util.*;

public class Cow_Pizza {

    static boolean contains(HashSet<Integer> a, HashSet<Integer> b, int toppings) {
        for (int i = 1; i <= toppings; i++) {
            if (a.contains(i) && (b.contains(i))) return true;
        }
        return false;
    }

    static int generate (int limit, int toppings, ArrayList<HashSet<Integer>> constraints, HashSet<Integer> comparer, int n, int b) {
        if (comparer.size() == limit) {
            for (int i = 0; i < constraints.size(); i++) {
                if (comparer.containsAll(constraints.get(i))) {
                    return 0;
                }
            }
            return 1;
        }
        else{
            for (int i = b; i <= toppings; i++) {
                if (comparer.contains(i)) continue;
                comparer.add(i);
                n += generate(limit, toppings, constraints, comparer, 0, i + 1);
                comparer.remove(i);
            }
            return n;
        }
    }

    public static void main(String [] args) {

        Scanner sc= new Scanner(System.in);
        int toppings = sc.nextInt();
        int nofconstraints = sc.nextInt();
        ArrayList<HashSet<Integer>> constraints = new ArrayList<>();
        for (int i = 0; i < nofconstraints; i++) {
            constraints.add(new HashSet<Integer>());
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                constraints.get(i).add(sc.nextInt());
            }
        }

        int counter = 0;

        for (int i = 1; i <= toppings; i++) {
            counter += generate(i, toppings, constraints, new HashSet<Integer>(), 0, 1);
        }

        System.out.println(counter + 1);

    }

}
