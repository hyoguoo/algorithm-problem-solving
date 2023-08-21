/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2667
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Numbering {

    final static int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    final static int EXIST = 1;
    final static int VISITED = -1;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        List<Integer> result = solution();
        printResult(result);
    }

    private static void printResult(List<Integer> result) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(result.size()).append("\n");
        result.stream().sorted().forEach(integer -> stringBuilder.append(integer).append("\n"));
        System.out.println(stringBuilder);
    }

    private static List<Integer> solution() {
        List<Integer> result = new ArrayList<>();

        for (int n = 0; n < map.length; n++) {
            for (int m = 0; m < map[n].length; m++) {
                if (map[n][m] == EXIST) result.add(bfs(n, m));
            }
        }

        return result;
    }

    private static int bfs(int startN, int startM) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(startN, startM));
        int count = 0;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (map[current.n][current.m] != EXIST) continue;
            map[current.n][current.m] = VISITED;
            count++;

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];
                if (!isInBound(nextN, nextM, map)) continue;
                queue.add(new Coordinate(nextN, nextM));
            }
        }

        return count;
    }

    private static boolean isInBound(int n, int m, int[][] map) {
        return n >= 0 && n < map.length && m >= 0 && m < map[n].length;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];

        for (int n = 0; n < N; n++) {
            int[] input = Arrays.stream(bufferedReader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            map[n] = input;
        }
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
