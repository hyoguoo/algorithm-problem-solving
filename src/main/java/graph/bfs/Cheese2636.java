/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2636
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cheese2636 {

    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final int EXIST = 1;
    static final int EMPTY = 0;
    static final int START_N = 0;
    static final int START_M = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int m = info[1];
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        solution(map);
    }

    private static void solution(int[][] map) {
        int time = 0;
        int lastCount = 0;

        while (true) {
            int count = melting(map);
            if (count == 0) break;
            lastCount = count;
            time++;
        }

        System.out.println(time);
        System.out.println(lastCount);
    }

    private static int melting(int[][] map) {
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        List<Coordinate> cheeseList = new LinkedList<>();

        queue.add(new Coordinate(START_N, START_M));
        visited[START_N][START_M] = true;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (map[current.n][current.m] == EXIST) {
                cheeseList.add(current);
                continue;
            }

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];
                if (!isInBound(map, nextN, nextM) ||
                    visited[nextN][nextM]) continue;
                visited[nextN][nextM] = true;
                queue.add(new Coordinate(nextN, nextM));
            }
        }

        return eraseCheese(map, cheeseList);
    }

    private static int eraseCheese(int[][] map, List<Coordinate> cheeseList) {
        for (Coordinate cheese : cheeseList) {
            map[cheese.n][cheese.m] = EMPTY;
        }

        return cheeseList.size();
    }

    private static boolean isInBound(int[][] map, int nextN, int nextM) {
        return 0 <= nextN && nextN < map.length && 0 <= nextM && nextM < map[0].length;
    }

    static class Coordinate {
        int n;
        int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
