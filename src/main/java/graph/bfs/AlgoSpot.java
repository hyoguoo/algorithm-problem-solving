/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1261
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

public class AlgoSpot {

    static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static final int WALL = 1;
    static final int EMPTY = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = info[0];
        int n = info[1];
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(bufferedReader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(solution(graph));
    }

    private static int solution(int[][] graph) {
        final int START_N = 0;
        final int START_M = 0;
        final int END_N = graph.length - 1;
        final int END_M = graph[0].length - 1;

        PriorityQueue<Coordinate> queue = new PriorityQueue<>();
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        queue.add(new Coordinate(START_N, START_M, 0));
        visited[START_N][START_M] = true;

        while (!queue.isEmpty()) {
            Coordinate poll = queue.poll();

            if (poll.n == END_N && poll.m == END_M) return poll.count;

            for (int[] direction : DIRECTIONS) {
                int nextN = poll.n + direction[0];
                int nextM = poll.m + direction[1];

                if (!isInBound(nextN, nextM, graph) ||
                    visited[nextN][nextM]) continue;
                visited[nextN][nextM] = true;

                if (graph[nextN][nextM] == WALL) queue.add(new Coordinate(nextN, nextM, poll.count + 1));
                else if (graph[nextN][nextM] == EMPTY) queue.add(new Coordinate(nextN, nextM, poll.count));
            }
        }

        return -1;
    }

    private static boolean isInBound(int n, int m, int[][] graph) {
        return 0 <= n && n < graph.length && 0 <= m && m < graph[0].length;
    }


    static class Coordinate implements Comparable<Coordinate> {
        int n;
        int m;
        int count;

        public Coordinate(int n, int m, int count) {
            this.n = n;
            this.m = m;
            this.count = count;
        }

        @Override
        public int compareTo(Coordinate o) {
            return this.count - o.count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return n == that.n && m == that.m && count == that.count;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n, m, count);
        }
    }
}
