import java.util.*;

public class Daisy_Chains {

    static void dfs(int[][] connections, int a, int x, int y, HashSet<Integer> cows) {

        if (x + 1 >= connections.length) x = 0;
        outer : for (int i = x ; i < connections.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (connections[i][j] == a) {
                    if (j == 0) {
                        cows.remove(connections[i][0]);
                        int temp = connections[i][1];
                        if (temp == 1) continue;
                        connections[i][1] = -1;
                        connections[i][0] = -1;
                        dfs(connections, temp, 0, 0, cows);
                        break outer;
                    } else {
                        cows.remove(connections[i][1]);
                        int temp = connections[i][0];
                        if (temp == 1) continue;
                        connections[i][0] = -1;
                        connections[i][1] = -1;
                        dfs(connections, temp, 0, 0, cows);
                        break outer;
                    }
                }
            }
            if (i == connections.length - 1) {
                cows.remove(a);
                break outer;
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nofcows = sc.nextInt();
        int nofconnections = sc.nextInt();

        int[][] connections = new int[nofconnections][2];

        for (int i = 0; i < nofconnections; i++) {
            connections[i][0] = sc.nextInt();
            connections[i][1] = sc.nextInt();
        }

        HashSet<Integer> cows = new HashSet<>();
        for (int i = 2; i <= nofcows; i++) {
            cows.add(i);
        }
        for (int i = 0; i < nofconnections; i++) {
            for (int j = 0; j < 2; j++) {
                if (connections[i][j] == 1) {
                    if (j == 1) {
                        dfs(connections, connections[i][0], 0, 0, cows);
                    } else dfs(connections, connections[i][1], 0, 1, cows);
                }
            }
        }

        List<Integer> list = new ArrayList<Integer>(cows);
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        if (list.size() == 0) System.out.println(0);

    }

}
