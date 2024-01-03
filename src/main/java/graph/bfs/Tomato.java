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

    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final int EXIST = 0;
    static final int RIPEN = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = info[0];
        int n = info[1];
        int[][] board = new int[n][m];

        Queue<Coordinate> ripenQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                if (input[j] == RIPEN) ripenQueue.add(new Coordinate(i, j));
                board[i][j] = input[j];
            }
        }

        System.out.println(solution(board, ripenQueue));
    }

    private static int solution(int[][] board, Queue<Coordinate> ripenQueue) {
        while (!ripenQueue.isEmpty()) {
            Coordinate current = ripenQueue.poll();

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (!isInBound(nextN, nextM, board) ||
                    board[nextN][nextM] != EXIST) continue;

                board[nextN][nextM] = board[current.n][current.m] + 1;
                ripenQueue.add(new Coordinate(nextN, nextM));
            }
        }

        return getMaxDay(board);
    }

    private static int getMaxDay(int[][] board) {
        int max = 0;

        for (int[] row : board) {
            for (int tomato : row) {
                if (tomato == EXIST) return -1;
                max = Math.max(max, tomato);
            }
        }

        return max - 1;
    }

    private static boolean isInBound(int n, int m, int[][] board) {
        return 0 <= n && n < board.length && 0 <= m && m < board[0].length;
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
