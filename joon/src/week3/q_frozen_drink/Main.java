package week3.q_frozen_drink;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static boolean[][] grid;
    static int n, m, count;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j) == '0';
            }
        }

        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) count++;
                dfs(i, j);
            }
        }

        result.append(count);
        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int x, int y) {
        if (grid[x][y]) {
            grid[x][y] = false;
            if (x - 1 > -1) {
                dfs(x - 1, y);
            }
            if (x + 1 < n) {
                dfs(x + 1, y);
            }
            if (y - 1 > -1) {
                dfs(x, y - 1);
            }
            if (y + 1 < m) {
                dfs(x, y + 1);
            }
        }
    }
}
