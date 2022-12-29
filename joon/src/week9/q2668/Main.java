package week9.q2668;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static List<Integer> list;
    private static List<Integer> cycle;
    private static List<Boolean> visited;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>(n + 1);
        list.add(0);
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        cycle = new ArrayList<>(n);
        visited = new ArrayList<>(n + 1);
        for (int j = 0; j < n + 1; j++) {
            visited.add(false);
        }

        for (int i = 1; i < n + 1; i++) {
            visited.set(i, true);
            dfs(i, i);
            visited.set(i, false);
        }

        Collections.sort(cycle);
        System.out.println(cycle.size());

        for (int i : cycle) {
            System.out.println(i);
        }

        br.close();

    }

    private static void dfs(int start, int target) {
        if (!visited.get(list.get(start))) {
            visited.set(list.get(start), true);
            dfs(list.get(start), target);
            visited.set(list.get(start), false);
        }

        if (list.get(start) == target) {
            cycle.add(target);
        }
    }
}
