/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4179 / 5427
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

public class Fires {

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static final char WALL = '#';
    static final char FIRE = '*';
    static final char ME = '@';
    static final int NOT_EXIST = -1;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCase-- > 0) {
            stringBuilder.append(solution()).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution() throws IOException {
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = info[0];
        int n = info[1];

        char[][] board = new char[n][m];
        int[][] fireDistance = new int[n][m];
        int[][] meDistance = new int[n][m];

        Queue<Coordinate> fireQueue = new LinkedList<>();
        Queue<Coordinate> meQueue = new LinkedList<>();

        initialized(n, m, board, fireDistance, meDistance, fireQueue, meQueue);
        fireSpread(fireQueue, n, m, fireDistance, board);
        int result = move(meQueue, n, m, meDistance, board, fireDistance);

        return result == -1
                ? "IMPOSSIBLE"
                : result + "";
    }

    private static void initialized(int n, int m, char[][] board, int[][] fireDistance, int[][] meDistance, Queue<Coordinate> fireQueue, Queue<Coordinate> meQueue) throws IOException {
        for (int i = 0; i < n; i++) {
            char[] s = bufferedReader.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = s[j];
                fireDistance[i][j] = NOT_EXIST;
                meDistance[i][j] = NOT_EXIST;
                if (board[i][j] == FIRE) {
                    fireQueue.offer(new Coordinate(i, j));
                    fireDistance[i][j] = 0;
                }
                if (board[i][j] == ME) {
                    meQueue.offer(new Coordinate(i, j));
                    meDistance[i][j] = 0;
                }
            }
        }
    }

    private static void fireSpread(Queue<Coordinate> fireQueue, int n, int m, int[][] fireDistance, char[][] board) {
        while (!fireQueue.isEmpty()) {
            Coordinate current = fireQueue.poll();

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (isOutBound(nextN, nextM, n, m) ||
                    fireDistance[nextN][nextM] >= 0 ||
                    board[nextN][nextM] == WALL) continue;

                fireDistance[nextN][nextM] = fireDistance[current.n][current.m] + 1;
                fireQueue.offer(new Coordinate(nextN, nextM));
            }
        }
    }

    private static int move(Queue<Coordinate> meQueue, int n, int m, int[][] meDistance, char[][] board, int[][] fireDistance) {
        while (!meQueue.isEmpty()) {
            Coordinate current = meQueue.poll();

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (isOutBound(nextN, nextM, n, m)) return meDistance[current.n][current.m] + 1;
                if (meDistance[nextN][nextM] >= 0 ||
                    board[nextN][nextM] == WALL ||
                    (fireDistance[nextN][nextM] <= meDistance[current.n][current.m] + 1) && fireDistance[nextN][nextM] != NOT_EXIST)
                    continue;
                meDistance[nextN][nextM] = meDistance[current.n][current.m] + 1;
                meQueue.offer(new Coordinate(nextN, nextM));
            }
        }

        return -1;
    }

    private static boolean isOutBound(int n, int m, int limitN, int limitM) {
        return n < 0 || limitN <= n || m < 0 || limitM <= m;
    }

    static class Coordinate {

        int n;
        int m;

        Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
