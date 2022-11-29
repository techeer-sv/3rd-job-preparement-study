package week5.q1326;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder result = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<Integer>[] graph;
    static int node, a, b, temp, count, size;

    public static void main(String[] args) throws Exception {

        node = Integer.parseInt(br.readLine());
        graph = new LinkedList[node + 1];
        setNode();

        result.append(bfs());
        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void setNode() throws IOException {
        for (int i = 1; i < node + 1; i++) {
            graph[i] = new LinkedList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < node + 1; i++) {
            temp = Integer.parseInt(st.nextToken());
            // 양의 배수로 갈 수 있는 경우 추가
            count = 1;
            while (i + temp * count <= node) {
                graph[i].add(i + temp * count);
                count++;
            }
            // 음의 배수로 갈 수 있는 경우 추가
            count = -1;
            while (0 < i + temp * count) {
                graph[i].add(i + temp * count);
                count--;
            }
        }
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
    }

    private static int bfs() {
        Deque<Integer> deque = new ArrayDeque<>(node);
        List<Boolean> visit = new ArrayList<>(node);
        for (int i = 0; i < node + 1; i++) {
            visit.add(false);
        }
        int res = -1;
        deque.add(a);
        while (!deque.isEmpty()) {
            size = deque.size();
            res++;
            for (int i = 0; i < size; i++) {
                temp = deque.poll();
                if (temp == b) return res;
                visit.set(temp, true);
                graph[temp].forEach(n -> {
                    if (Boolean.FALSE.equals(visit.get(n))) {
                        deque.add(n);
                    }
                });
            }
        }
        return -1;
    }
}

/*
예제 입력
5
1 2 2 1 2
1 5

5
2 1 1 1 1
1 5

예제 출력
1
 */