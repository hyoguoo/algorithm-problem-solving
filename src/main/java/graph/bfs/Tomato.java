/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 7576
 * Cheat Level: 2
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato {

    final static Queue<Coordinate> ripenQueue = new LinkedList<>();
    final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    final static int TOMATO = 0;
    final static int RIPEN = 1;
    static int[][] board;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = info[0];
        N = info[1];
        board = new int[N][M];

        for (int n = 0; n < N; n++) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int m = 0; m < M; m++) {
                if (input[m] == RIPEN) ripenQueue.add(new Coordinate(n, m));
                board[n][m] = input[m];
            }
        }

        System.out.println(solution());
    }

    private static int solution() {
        while (!ripenQueue.isEmpty()) {
            Coordinate current = ripenQueue.poll();

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (isInBound(nextN, nextM) && board[nextN][nextM] == TOMATO) {
                    board[nextN][nextM] = board[current.n][current.m] + 1;
                    ripenQueue.add(new Coordinate(nextN, nextM));
                }
            }
        }

        return getMaxDay();
    }

    private static int getMaxDay() {
        int max = 0;

        for (int[] row : board) {
            for (int tomato : row) {
                if (tomato == TOMATO) return -1;
                max = Math.max(max, tomato);
            }
        }

        return max - 1;
    }

    private static boolean isInBound(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < M;
    }

    static class Coordinate {
        int n, m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
