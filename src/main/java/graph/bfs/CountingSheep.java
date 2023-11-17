/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11123
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class CountingSheep {

    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final char SHEEP = '#';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        while (testCount-- > 0) {
            String[] info = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(info[0]);
            int m = Integer.parseInt(info[1]);
            char[][] map = new char[n][m];

            for (int i = 0; i < n; i++) {
                map[i] = bufferedReader.readLine().toCharArray();
            }

            stringBuilder.append(solution(n, m, map)).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static int solution(int n, int m, char[][] map) {
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == SHEEP && !visited[i][j]) {
                    count++;
                    bfs(map, visited, i, j);
                }
            }
        }

        return count;
    }

    private static void bfs(char[][] map, boolean[][] visited, int n, int m) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(n, m));
        visited[n][m] = true;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (isInBound(map, nextN, nextM) &&
                    map[nextN][nextM] == SHEEP &&
                    !visited[nextN][nextM]) {
                    queue.add(new Coordinate(nextN, nextM));
                    visited[nextN][nextM] = true;
                }
            }
        }
    }

    private static boolean isInBound(char[][] map, int nextN, int nextM) {
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
