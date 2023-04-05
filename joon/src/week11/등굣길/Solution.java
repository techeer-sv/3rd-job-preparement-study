package week11.등굣길;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private static Location location = new Location(1, 1);
    private static int m, n, answer;
    private static boolean flag = true;
    private static int [][] puddles;
    private static Queue<Location> bfs = new LinkedList<>();

    public int solution(int m, int n, int[][] puddles) {
        this.m = m;
        this.n = n;
        this.puddles = puddles;
        bfs.add(location);

        while (flag) {
            int size = bfs.size();

            for (int i = 0; i < size; i++) {
                Location l = bfs.poll();
                insert(l.x + 1, l.y);
                insert(l.x, l.y + 1);
            }
        }
        return answer % 1000000007;
    }

    public void insert(int x, int y) {
        if (x == m && y == n) {
            flag = false;
            answer++;
        } else if (x <= m && y <= n) {
            for (var j : puddles) {
                if (j[0] == x && j[1] == y) {
                    return;
                }
            }
            bfs.add(new Location(x, y));
        }
    }

    static class Location {
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
