package week5.q7569;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
토마토

예제 입력
5 3 2
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 1 0 0
0 0 0 0 0

예제 출력
4

 */

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder result = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int x, y, z, count = -1, todo = 0;
    static int[][][] cube;
    static int[][] move = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        z = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        cube = new int[x][y][z];

        Queue<Node> deque = new ArrayDeque<>(z * y * x);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < z; k++) {
                    cube[i][j][k] = Integer.parseInt(st.nextToken());
                    if (cube[i][j][k] == 1) deque.add(new Node(i, j, k));
                    else if (cube[i][j][k] == 0) todo++;
                }
            }
        }

        if (todo == 0) {
            result.append(0);
            bw.write(String.valueOf(result));
            bw.flush();
            return;
        }

        bfs(deque);

        if (todo > 0)
            result.append(-1);
        else
            result.append(count);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void bfs(Queue<Node> deque) {
        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                Node node = deque.poll();

                if (cube[node.x][node.y][node.z] == 1) cube[node.x][node.y][node.z] = -1;
                else if (cube[node.x][node.y][node.z] == 0) {
                    cube[node.x][node.y][node.z] = -1;
                    todo--;
                } else continue;

                for (int j = 0; j < 6; j++) {
                    if (node.x + move[j][0] < x &&
                            -1 < node.x + move[j][0] &&
                            node.y + move[j][1] < y &&
                            -1 < node.y + move[j][1] &&
                            node.z + move[j][2] < z &&
                            -1 < node.z + move[j][2] &&
                            cube[node.x + move[j][0]][node.y + move[j][1]][node.z + move[j][2]] == 0)
                        deque.add(new Node(node.x + move[j][0], node.y + move[j][1], node.z + move[j][2]));
                }
            }
            count++;
            if (todo == 0) break;
        }
    }

    static class Node {
        int x, y, z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
