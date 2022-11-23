package week5.q16236;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/* 아기 상어

예제 입력

6
5 4 3 2 3 4
4 3 2 3 4 5
3 2 9 5 6 6
2 1 2 3 4 5
3 2 1 6 5 4
6 6 6 6 6 6

예제 출력

60

 */
public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder result = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, size = 2, feed = 0, total = 0, startX, startY;
    static int[][] grid;
    static boolean[][] visit;
    static Result res;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 9) {
                    startX = i;
                    startY = j;
                    grid[i][j] = 0;
                }
            }
        }

        while (true) {
            res = bfs(startX, startY);
            if (!res.eat) break;
            total += res.count;
            feed++;
            if (feed == size) {
                size++;
                feed = 0;
            }
        }

        result.append(total);
        bw.write(result.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Result {
        int count;
        boolean eat;

        public Result(int count, boolean eat) {
            this.count = count;
            this.eat = eat;
        }
    }

    private static Result bfs(int x, int y) {
        List<Node> canEat = new LinkedList<>();
        Deque<Node> deque = new ArrayDeque<>();
        visit = new boolean[n][n];

        deque.add(new Node(x, y));
        int count = 0;

        while (!deque.isEmpty()) {
            int qSize = deque.size();
            boolean flag = false;

            for (int i = 0; i < qSize; i++) {
                Node node = deque.poll();
                x = node.x;
                y = node.y;
                int fish = grid[x][y];

                if (fish != 0 && fish < size) {
                    flag = true;
                    canEat.add(node);
                }

                if (visit[x][y]) continue;
                visit[x][y] = true;

                if (!flag && (fish == 0 || fish == size)) {
                    if (x - 1 > -1) {
                        deque.add(new Node(x - 1, y));
                    }
                    if (y - 1 > -1) {
                        deque.add(new Node(x, y - 1));
                    }
                    if (y + 1 < n) {
                        deque.add(new Node(x, y + 1));
                    }
                    if (x + 1 < n) {
                        deque.add(new Node(x + 1, y));
                    }
                }
            }

            if (flag) {
                Node best = new Node(99, 99);

                for (Node node : canEat)
                    if (node.x < best.x || (node.x == best.x && node.y < best.y))
                        best = node;

                grid[best.x][best.y] = 0;
                startX = best.x;
                startY = best.y;

                return new Result(count, true);
            }
            count++;
        }
        return new Result(0, false);
    }
}
