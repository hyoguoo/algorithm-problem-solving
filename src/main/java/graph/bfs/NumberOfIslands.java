/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4963
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

public class NumberOfIslands {

    final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    final static int LAND = 1;
    final static int VISITED = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = info[1];
            int M = info[0];
            if (N == 0 && M == 0) break;
            int[][] board = new int[N][M];
            for (int n = 0; n < N; n++) {
                board[n] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            stringBuilder.append(solution(board)).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static int solution(int[][] board) {
        int count = 0;

        for (int n = 0; n < board.length; n++) {
            for (int m = 0; m < board[0].length; m++) {
                if (board[n][m] == LAND) {
                    bfs(board, n, m);
                    count++;
                }
            }
        }

        return count;
    }

    private static void bfs(int[][] board, int n, int m) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(n, m));

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (isInBound(nextN, nextM, board.length, board[0].length) && board[nextN][nextM] == LAND) {
                    board[nextN][nextM] = VISITED;
                    queue.add(new Coordinate(nextN, nextM));
                }
            }
        }
    }

    private static boolean isInBound(int n, int m, int N, int M) {
        return 0 <= n && n < N && 0 <= m && m < M;
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
