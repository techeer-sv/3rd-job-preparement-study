package week3.q_escape_maze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
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
                grid[i][j] = line.charAt(j) == '1';
            }
        }
        Deque<Integer> xDeque = new ArrayDeque<>();
        Deque<Integer> yDeque = new ArrayDeque<>();
        xDeque.add(0);
        yDeque.add(0);
        count = 0;
        while (!xDeque.isEmpty() && !yDeque.isEmpty()) {
            int size = xDeque.size();
            count++;
            for (int i = 0; i < size; i++) {
                int x = xDeque.poll();
                int y = yDeque.poll();

                if (x == n - 1 && y == m - 1) {
                    result.append(count);
                    bw.write(result.toString());
                    bw.flush();
                    br.close();
                    bw.close();
                    return;
                } else if (grid[x][y]) {
                    grid[x][y] = false;
                    if (x - 1 > -1) {
                        xDeque.add(x - 1);
                        yDeque.add(y);
                    }
                    if (x + 1 < n) {
                        xDeque.add(x + 1);
                        yDeque.add(y);
                    }
                    if (y - 1 > -1) {
                        xDeque.add(x);
                        yDeque.add(y - 1);
                    }
                    if (y + 1 < m) {
                        xDeque.add(x);
                        yDeque.add(y + 1);
                    }
                }
            }
        }
    }
}
