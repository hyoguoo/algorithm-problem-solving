/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4485
 * Cheat Level: 0
 * Algorithm: Dijkstra / Graph
 */

package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class GreenSuitIsZelda {

    static final String RESULT_FORMAT = "Problem %d: %d\n";
    static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int problemNumber = 1;
        while (true) {
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n == 0) break;
            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++) {
                board[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            System.out.printf(RESULT_FORMAT, problemNumber++, solution(board));
        }
    }

    private static int solution(int[][] board) {
        int[][] distances = new int[board.length][board[0].length];
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        for (int[] distance : distances) Arrays.fill(distance, INF);

        priorityQueue.add(new Vertex(0, 0, board[0][0]));
        distances[0][0] = board[0][0];

        while (!priorityQueue.isEmpty()) {
            Vertex current = priorityQueue.poll();

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];
                if (!isInBound(nextN, nextM, board)) continue;
                int newCost = distances[current.n][current.m] + board[nextN][nextM];
                if (distances[nextN][nextM] <=newCost) continue;
                distances[nextN][nextM] = newCost;
                priorityQueue.add(new Vertex(nextN, nextM, newCost));
            }
        }

        return distances[board.length - 1][board.length - 1];
    }

    private static boolean isInBound(int n, int m, int[][] board) {
        return 0 <= n && n < board.length && 0 <= m && m < board[0].length;
    }

    static class Vertex implements Comparable<Vertex> {
        int n;
        int m;
        int cost;

        public Vertex(int n, int m, int cost) {
            this.n = n;
            this.m = m;
            this.cost = cost;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.cost - o.cost;
        }
    }
}
