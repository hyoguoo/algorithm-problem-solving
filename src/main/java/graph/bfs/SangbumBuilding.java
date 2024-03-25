/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 6593
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SangbumBuilding {

    static final BufferedReader BUFFERED_READER =
            new BufferedReader(new InputStreamReader(System.in));
    static final String NOT_REACH_RESULT_FORMAT = "Trapped!";
    static final String REACH_RESULT_FORMAT = "Escaped in %d minute(s).";
    static final int[][] DIRECTIONS = {
            {0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0},
            {1, 0, 0}, {-1, 0, 0}
    };
    static final char WALL = '#';
    static final char START = 'S';
    static final char EXIT = 'E';
    static final int NOT_REACH = -1;
    static final int NOT_VISIT = 0;

    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int[] info = Arrays.stream(BUFFERED_READER.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int f = info[0];
            int n = info[1];
            int m = info[2];
            if (f == 0 && n == 0 && m == 0) {
                break;
            }

            char[][][] graph = parseMap(f, n, m);
            int result = solution(graph);

            stringBuilder
                    .append(
                            result == NOT_REACH
                                    ? NOT_REACH_RESULT_FORMAT
                                    : String.format(REACH_RESULT_FORMAT, result)
                    )
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(char[][][] graph) {
        Coordinate start = findCoordinateByValue(graph, START);
        int[][][] visited = new int[graph.length][graph[0].length][graph[0][0].length];

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (graph[current.f][current.n][current.m] == EXIT) {
                return visited[current.f][current.n][current.m];
            }

            for (int[] direction : DIRECTIONS) {
                int nextF = current.f + direction[0];
                int nextN = current.n + direction[1];
                int nextM = current.m + direction[2];

                if (!isInBound(graph, nextF, nextN, nextM) ||
                        graph[nextF][nextN][nextM] == WALL ||
                        visited[nextF][nextN][nextM] != NOT_VISIT) {
                    continue;
                }
                queue.add(
                        new Coordinate(
                                nextF,
                                nextN,
                                nextM
                        )
                );
                visited[nextF][nextN][nextM] = visited[current.f][current.n][current.m] + 1;
            }
        }

        return NOT_REACH;
    }

    private static Coordinate findCoordinateByValue(char[][][] graph, char value) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                for (int k = 0; k < graph[i][j].length; k++) {
                    if (graph[i][j][k] == value) {
                        return new Coordinate(i, j, k);
                    }
                }
            }
        }

        return null;
    }

    private static boolean isInBound(char[][][] graph, int f, int n, int m) {
        return 0 <= f && f < graph.length &&
                0 <= n && n < graph[f].length &&
                0 <= m && m < graph[f][n].length;
    }

    private static char[][][] parseMap(int f, int n, int m) throws IOException {
        char[][][] graph = new char[f][n][m];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = BUFFERED_READER.readLine().toCharArray();
            }
            BUFFERED_READER.readLine();
        }

        return graph;
    }

    static class Coordinate {

        int f;
        int n;
        int m;

        public Coordinate(int f, int n, int m) {
            this.f = f;
            this.n = n;
            this.m = m;
        }
    }
}
