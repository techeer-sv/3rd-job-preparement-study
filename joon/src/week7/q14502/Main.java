package week7.q14502;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/*
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0

27
 */
public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder result = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] originalGrid;
    static int[][] tempGrid;
    static int n, m;
    static int[] dr = {-1, 1, 0, 0}; //상하좌우
    static int[] dc = {0, 0, -1, 1}; //상하좌우
    static int res = Integer.MIN_VALUE; //안전지역 개수


    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        originalGrid = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int v = Integer.parseInt(st.nextToken());
                originalGrid[i][j] = v;
            }
        }

        tempGrid = originalGrid.clone();

        DFS(0);

        result.append(res);
        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int depth) {
        //벽 3개를 다 세웠으면 바이러스 뿌려!
        if (depth == 3) {
            BFS();
            return;
        }

        //벽 3개 못 세웠으면 다시 세워!
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //빈칸이라면
                if (tempGrid[i][j] == 0) {
                    //벽 세우고
                    tempGrid[i][j] = 1;
                    DFS(depth + 1);
                    //다시 돌려놓고
                    tempGrid[i][j] = 0;
                }
            }
        }
    }

    public static void BFS() {

        int[][] virusGrid = new int[n][m];
        Queue<Location> tempQueue = new LinkedList<>();

        //virus map 카피
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                virusGrid[i][j] = tempGrid[i][j];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                //바이러스라면 큐에 넣어
                if (virusGrid[i][j] == 2)
                    tempQueue.add(new Location(i, j));

        while (!tempQueue.isEmpty()) {
            Location v = tempQueue.remove();

            for (int d = 0; d < 4; d++) {
                int nr = v.x + dr[d];
                int nc = v.y + dc[d];

                //범위 안에 있으면
                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    //빈칸이라면 바이러스 퍼뜨려 그리고 다시 큐에 넣어
                    if (virusGrid[nr][nc] == 0) {
                        virusGrid[nr][nc] = 2;
                        tempQueue.add(new Location(nr, nc));
                    }
                }
            }
        }
        safe(virusGrid);
    }

    public static void safe(int[][] virusGrid) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virusGrid[i][j] == 0) count++;
            }
        }

        res = Math.max(count, res);
    }

    static class Location {
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
