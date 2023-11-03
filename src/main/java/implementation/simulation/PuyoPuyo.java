/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11559
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation / Graph / BFS
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PuyoPuyo {

    static final int N = 12;
    static final int M = 6;
    static final int POP_MIN = 4;
    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final char[][] FIELD = new char[N][M];
    static final char EMPTY = '.';

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static int solution() {
        int count = 0;

        while (true) {
            boolean[][] visited = new boolean[N][M];
            List<Coordinate> popList = getPoppedPuyos(visited);

            if (popList.isEmpty()) break;
            pop(popList);
            count++;
        }

        return count;
    }

    private static List<Coordinate> getPoppedPuyos(boolean[][] visited) {
        List<Coordinate> popList = new ArrayList<>();

        for (int n = N - 1; n >= 0; n--) {
            for (int m = 0; m < M; m++) {
                char color = FIELD[n][m];
                if (color != EMPTY && !visited[n][m]) {
                    List<Coordinate> chainedBlocks = bfs(visited, new Coordinate(n, m), color);
                    if (chainedBlocks.size() >= POP_MIN) popList.addAll(chainedBlocks);
                }
            }
        }
        return popList;
    }

    private static void pop(List<Coordinate> popList) {
        for (Coordinate coordinate : popList) {
            FIELD[coordinate.n][coordinate.m] = EMPTY;
        }

        rearrangePuyos();
    }

    private static void rearrangePuyos() {
        for (int m = 0; m < M; m++) {
            for (int n = N - 1; n >= 0; n--) {
                if (FIELD[n][m] == EMPTY) {
                    for (int i = n - 1; i >= 0; i--) {
                        if (FIELD[i][m] != EMPTY) {
                            FIELD[n][m] = FIELD[i][m];
                            FIELD[i][m] = EMPTY;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static List<Coordinate> bfs(boolean[][] visited, Coordinate start, char color) {
        Queue<Coordinate> queue = new LinkedList<>();
        List<Coordinate> chainedBlocks = new ArrayList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (visited[current.n][current.m]) continue;
            visited[current.n][current.m] = true;
            chainedBlocks.add(new Coordinate(current.n, current.m));

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];
                if (!isInBound(nextN, nextM)
                    || FIELD[nextN][nextM] != color) continue;
                queue.add(new Coordinate(nextN, nextM));
            }
        }

        return chainedBlocks;
    }

    private static boolean isInBound(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < M;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int n = 0; n < N; n++) {
            String line = bufferedReader.readLine();
            for (int m = 0; m < M; m++) {
                FIELD[n][m] = line.charAt(m);
            }
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
