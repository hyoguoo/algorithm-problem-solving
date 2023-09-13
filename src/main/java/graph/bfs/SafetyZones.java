/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2668
 * Cheat Level: 0
 * Algorithm: Graph / BFS / Simulation
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SafetyZones {

    final static int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] board;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        board = new int[N][N];
        for (int n = 0; n < N; n++) {
            board[n] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(solution());
    }

    private static int solution() {
        int maxCount = 1;

        for (int limit = 2; limit <= 100; limit++) {
            maxCount = Math.max(maxCount, countZones(limit));
        }

        return maxCount;
    }

    private static int countZones(int limit) {
        boolean[][] visited = new boolean[N][N];
        int count = 0;

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < N; m++) {
                if (board[n][m] > limit && !visited[n][m]) {
                    bfs(n, m, visited, limit);
                    count++;
                }
            }
        }

        return count;
    }

    private static void bfs(int n, int m, boolean[][] visited, int limit) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(n, m));

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (visited[current.n][current.m]) continue;
            visited[current.n][current.m] = true;

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (!isInBound(nextN, nextM) || board[nextN][nextM] <= limit) continue;
                queue.add(new Coordinate(nextN, nextM));
            }
        }
    }


    private static boolean isInBound(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < N;
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
